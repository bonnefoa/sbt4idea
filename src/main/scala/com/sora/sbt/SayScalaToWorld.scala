package com.sora.sbt

import com.intellij.openapi.actionSystem.{AnActionEvent, AnAction}
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.project.ProjectManager
import com.intellij.openapi.module.ModuleManager

/**
 * Created by IntelliJ IDEA.
 * User: sora
 * Date: Nov 14, 2009
 * Time: 12:01:14 AM
 * To change this template use File | Settings | File Templates.
 */

class SayScalaToWorld extends AnAction {
  def actionPerformed(e: AnActionEvent) = {
    ApplicationManager.getApplication().getComponent(classOf[ScalaTestComponent]).sayHello()
  }
}