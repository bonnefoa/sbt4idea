import sbt._

class RantProject(info: ProjectInfo) extends ParentProject(info)
{
  val nexus = "nexus" at "http://localhost:8080/nexus/content/groups/public/"
  class Test(info: ProjectInfo) extends DefaultProject(info) {
    val scalacheck = "org.scala-tools.testing" % "scalacheck" % "1.6" % "test->default" withSources ()
    val scalatest = "org.scalatest" % "scalatest" % "1.0" % "test->default" withSources ()
    val junit = "junit" % "junit" % "4.7" % "test->default" withSources ()
    val mockito = "org.mockito" % "mockito-all" % "1.8.0" % "test->default" withSources ()
    val specs = "org.scala-tools.testing" % "specs" % "1.6.0" % "test->default" withSources ()
  }

  lazy val core = project("core", "nexus meta script core", new DefaultProject(_),test)
  lazy val test = project("test", "test libs", new Test(_))
}
 
