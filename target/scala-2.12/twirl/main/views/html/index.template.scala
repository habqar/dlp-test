
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import scala.collection.JavaConverters._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import play.data._
import play.core.j.PlayFormsMagicForJava._

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.4*/("""

"""),_display_(/*3.2*/main("Disneyland Paris - Java Technical Test")/*3.48*/ {_display_(Seq[Any](format.raw/*3.50*/("""
  """),format.raw/*4.3*/("""<h1>Welcome!</h1>
  <p>
    This test is conceived to challenge you on some technical points, and also check how resourceful you can be.<br />
    This is why you may find some implementations to be easily implemented, the main point being to let you figure how to conceive them as mush as possible.<br />
    Also, the point is not to learn how Play Framework works in details, only to check how you can search for the right information online or in the existing code.<br />
    Do as much as you can in the allocated time.
  </p>
  <p>You'll find the steps to follow below.</p>

  <h2>1. Install & run</h2>
  <p>Congratulations, you've already performed this task !</p>

  <h2>2. Display a random image</h2>
  <p>
    The point of this task is to implement a simple GET request to the following endpoint and display the image.<br />
    https://picsum.photos/200/300<br />
    (Doc at https://picsum.photos/)
  </p>
  <ul>
    <li>You'll need to create a route pointing to the "test" method of HomeController. Let's say "/test".</li>
    <li>We do not want to ask for a different image at every call. You'll need to implement some caching mechanism relying on Play Cache API to keep the same URL (do not bother with caching the actual file). Let's keep the same image for 5 seconds.</li>
    <li>The URL of the endpoint, and the TTL should not be hardcoded, please put it in the configuration.</li>
    <li>You'll have to render a view for this, passing it the URL of the image. Please use Twirl.</li>
    <li>We will use WS and Play Cache (relying on ehcache), which are already injected in the controller mentioned above.</li>
  </ul>

  <h2>3. Display multiple images</h2>
  <p>
    The point of this task is to make another route that will display a list of images retrieved from the following API:<br />
    https://picsum.photos/v2/list
  </p>
  <ul>
    <li>You'll need to create a route pointing to a new method of HomeController. Let's say "/testMultiple".</li>
    <li>We only want to display images for which the ID is a multiple 2.</li>
    <li>We want to use only one view. Please update the one from before to handle both cases (tasks #2 and #3).</li>
    <li>It would be great to have a proper deserialization mechanism (relying on Jackson for instance ?).</li>
    <li>Consider the good practices mentioned for task #2.</li>
  </ul>

  <h2>4. Make it shine</h2>
  <p>
    Let's do some refactoring, and add a service to the mix.<br />
    Create a RandomImageService to generate the URLs of tasks 2 & 3 to have clean controllers.
  </p>
""")))}),format.raw/*48.2*/("""
"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Wed Oct 23 22:52:37 CEST 2019
                  SOURCE: C:/Users/HABQAR/Desktop/dlp-test/app/views/index.scala.html
                  HASH: 94ca07e481c0ac19defa3dc803f06f587a4495b2
                  MATRIX: 941->1|1037->3|1067->8|1121->54|1160->56|1190->60|3820->2660
                  LINES: 28->1|33->1|35->3|35->3|35->3|36->4|80->48
                  -- GENERATED --
              */
          