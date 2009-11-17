package sbt

import org.scalatest.matchers.ShouldMatchers
import org.scalatest.FlatSpec

/**
 * Test class for SbtManager
 */

class SbtManagerTest extends FlatSpec with ShouldMatchers {
  "The sbtManager" should "execute sbt" in {
    MySbtManager.executeSbt(Array("update"))
  }
  it should "get the project structure" in {

  }
}
