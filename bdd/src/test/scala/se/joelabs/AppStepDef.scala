package se.joelabs

import cucumber.api.scala.{EN, ScalaDsl}
import org.scalatest._

import se.joelabs.jenkinspipeline.App

class AppStepDef extends ScalaDsl with EN with Matchers {
  val app = new App
}
