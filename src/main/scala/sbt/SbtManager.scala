package sbt

import java.io.File
import com.intellij.openapi.components.ApplicationComponent

/**
 * Interaction with sbt
 */

class MySbtManager extends ApplicationComponent {
  def disposeComponent = {}

  def initComponent = {}

  def getComponentName = "MySbtManager"

  def executeSbt(args: Array[String]): Unit = {
    sbt.Main.main(args)
  }

  def discoverModules(): List[File] = {

    Nil
  }

  def getProject(): Project = {
val builderProjectPath = info.builderPath / Project.BuilderProjectDirectoryName    
  }
}