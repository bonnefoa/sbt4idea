package com.sora.sbt.classpath

import com.intellij.openapi.components.ProjectComponent
import com.intellij.openapi.roots.libraries.LibraryTable
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFileManager
import com.intellij.openapi.roots.ModuleRootManager
import com.intellij.openapi.module.ModuleManager
import com.intellij.openapi.module.ModuleType

/**
 * Created by IntelliJ IDEA.
 * User: sora
 * Date: Nov 16, 2009
 * Time: 8:46:29 PM
 * To change this template use File | Settings | File Templates.
 */

class ModuleManagement(val virtualFileManager: VirtualFileManager, val project: Project, val table: LibraryTable, val moduleManager: ModuleManager) extends ProjectComponent with Project{
  def createModule(name: String, filePath: String) = {
    val rootManager = moduleManager.newModule(filePath, ModuleType.EMPTY)
    rootManager
  }

  def discoverModules()={
//    new File("."), Nil, None, log
//			val builderProject = new BuilderProject(ProjectInfo(builderProjectPath.asFile, Nil, None)(buildLog), pluginProjectPath, additionalPaths, buildLog)
//this.
    sbt.Project.loadProject
    //    val ga = new ParentProject()
//    ga.dependencies
  }
}