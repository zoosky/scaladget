package demo

import fr.iscpif.scaladget.api.Select.Displayable
import fr.iscpif.scaladget.api.{BootstrapTags => bs}
import fr.iscpif.scaladget.tools.JsRxTags._
import fr.iscpif.scaladget.api.Popup._
import fr.iscpif.scaladget.api._
import fr.iscpif.scaladget.stylesheet.{all => sheet}
import scala.scalajs.js.JSApp
import scala.scalajs.js.annotation.JSExport
import org.scalajs.dom
import scalatags.JsDom.tags
import scalatags.JsDom.all._
import scalatags.JsDom.{styles => sty}
import sheet._
import bs._
import rx._

/*
 * Copyright (C) 24/03/16 // mathieu.leclaire@openmole.org
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */


@JSExport("Demo")
object BootstrapDemo extends JSApp{

  val a: Var[Boolean] = Var(false)

  case class TT(name: String) extends Displayable

  val sortingBar: ModifierSeq = Seq(
    color := "white",
    backgroundColor := "#333",
    opacity := "0.5",
    width := 35
  )

  val inner = div(
    bs.button("Run", btn_primary, ()=> println("button click")),
    label("Yop")(label_danger)
  )

  @JSExport
  def main(): Unit = {
    dom.document.body.appendChild(build)
  }


  def build = {
    val bottom = glyph_triangle_bottom +++ (fontSize := 10)
    val sel = Select(Seq(TT("aauieaa"), TT("bbeeaieai"), TT("uuuieuiecc")),
      Some(TT("bb")),
      btn_primary
    )
    a() = true
    tags.div(
      tags.table(sheet.table)(
        thead(
          tr(
            th("col1"),
            th("col2")
          )
        ),
        tbody(
          tr(
            td("Yo"),
            td("men")
          ),
          tr(
            td("mathieu"),
            td("leclaire")
          )
        )
      ),
      div("Grow")(ms("ufo-big") +++ (color := "white")),
      sel.selector,
      div("You")(btn_danger +++ (height := 50) +++ sheet.marginLeft(295)).tooltip(span("héhé"), position = Bottom, arrowStyle = whiteBottomArrow),
       div("Haha")(btn_info +++ sheet.marginLeft(295)).tooltip(span("héhé"), position = Right, arrowStyle = whiteRightArrow),
      div("Settings")(btn_primary, sheet.marginLeft(145)).popup(inner, position = Right, popupStyle = whitePopupWithBorder, arrowStyle = whiteRightArrow),
      div("Dialog")(btn_primary, sheet.marginLeft(145)).dialog(inner),
      tags.label("nrestiarn")(ms("oo")),
      span(glyph_trash),
      Rx {
        span(aria.hidden := "true", glyph_upload +++ ms("fileUpload glyphmenu"))
      },
      tags.div(
        sty.left := "40px",
        sty.width := "100%",
        exclusiveButtonGroup(sortingBar, ms("iii"), ms("yyy"))(
          ExclusiveButton.twoGlyphSpan(
            bottom,
            glyph_triangle_top,
            () ⇒ println("state 1"),
            () ⇒ println("state 2"),
            preString = "Aa"
          ),
          ExclusiveButton.twoGlyphButtonStates(
            bottom,
            glyph_triangle_top,
            () ⇒ println("state 1"),
            () ⇒ println("state 2"),
            preGlyph = glyph_time
          ),
          ExclusiveButton.twoGlyphSpan(
            bottom,
            glyph_triangle_top,
            () ⇒ println("state 1"),
            () ⇒ println("state 2"),
            preString = "Ko"
          ),
          ExclusiveButton.string("#", () => println("Yo #")),
          ExclusiveButton.string("Name", () => println("Yo name")
          )
        ).div
      )
    )
  }


}