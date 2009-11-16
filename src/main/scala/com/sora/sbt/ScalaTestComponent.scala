package com.sora.sbt

import com.intellij.openapi.components.ApplicationComponent
import com.intellij.openapi.ui.Messages

/**
 * Created by IntelliJ IDEA.
 * User: sora
 * Date: Nov 14, 2009
 * Time: 12:03:35 AM
 * To change this template use File | Settings | File Templates.
 */
class ScalaTestComponent extends ApplicationComponent {
  def disposeComponent = {}

  def initComponent = {}

  def getComponentName = "Scala"

  def sayHello() = {
    // Show dialog with message
    Messages.showMessageDialog(
      "SCALA",
      "Sample",
      Messages.getInformationIcon()
      )
  }
}