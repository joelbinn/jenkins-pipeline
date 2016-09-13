package se.joelabs

import cucumber.api.scala.{EN, ScalaDsl}
import org.scalatest._

import se.joelabs.jenkinspipeline.App

class AppStepDef extends ScalaDsl with EN with Matchers {
  val app = new App
  var result:String = _

  Given("""^the app has started$"""){ () =>

  }

  When("""^I do it$"""){ () =>
    result = app.getIt
  }

  Then("""^It is OK$"""){ () =>
    result should be("Banan")
  }

}
