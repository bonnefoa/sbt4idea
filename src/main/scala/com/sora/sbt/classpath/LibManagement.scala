package com.sora.sbt.classpath

import java.io.File
import com.intellij.openapi.module.Module
import com.intellij.openapi.roots.libraries.{Library, LibraryTable}
import com.intellij.openapi.roots.{OrderRootType, ModuleRootManager}
import com.intellij.openapi.vfs.{VirtualFile, VirtualFileManager, JarFileSystem}
import com.intellij.openapi.roots.libraries.Library.ModifiableModel
import com.intellij.openapi.project.Project
import com.intellij.openapi.components.ProjectComponent


class LibManagement(val virtualFileManager: VirtualFileManager, val project: Project, val table: LibraryTable) extends ProjectComponent {
  def addLibrary(module: Module, libName: String, jarFile: File): Unit = {
    val rootManager = ModuleRootManager.getInstance(module);
    val urlString = VirtualFileManager.constructUrl(JarFileSystem.PROTOCOL, jarFile.getAbsolutePath().replaceAll("\\\\", "/") + JarFileSystem.JAR_SEPARATOR);
    val jarVirtualFile = virtualFileManager.findFileByUrl(urlString);
    val newLib = createLib(libName, jarVirtualFile);
    val modifiableModel = rootManager.getModifiableModel();
    val existing = modifiableModel.findLibraryOrderEntry(newLib);
    if (existing == null) {
      modifiableModel.addLibraryEntry(newLib);
      modifiableModel.commit();
    }
  }

  def createLib(libName: String, jarVirtualFile: VirtualFile): Library = {
    val res = getLibrary(libName)
    val modifiableModel: ModifiableModel = res.getOrElse(table.createLibrary(libName)).getModifiableModel
    val roots = modifiableModel.getFiles(OrderRootType.CLASSES)
    if (!roots.exists(in => in.equals(jarVirtualFile))) {
      modifiableModel.addRoot(jarVirtualFile, OrderRootType.CLASSES)
      modifiableModel.commit
    }
    res.get
  }

  def getLibrary(libName: String): Option[Library] = {
    if (table.getLibraryByName(libName) != null)
      Some(table.getLibraryByName(libName))
    else None
  }
}
