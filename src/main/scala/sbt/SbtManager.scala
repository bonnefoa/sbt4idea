package sbt

import java.io.File

/**
 * Interaction with sbt
 */

object MySbtManager {
  def executeSbt(args: Array[String]): Unit = {
    sbt.Main.main(args)
  }

  def discoverModules(): List[File] = {

    Nil
  }
}