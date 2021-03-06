package demo


import scaladget.api.Selector
import scaladget.stylesheet.all
import org.scalajs.dom.Element
import org.scalajs.dom.raw.HTMLDivElement

/*
 * Copyright (C) 22/08/16 // mathieu.leclaire@openmole.org
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

import scaladget.api.{BootstrapTags => bs}
import scaladget.stylesheet.{all => sheet}
import scalatags.JsDom.all._
import sheet._
import bs._

object SelectDemo {

  val sc = sourcecode.Text {
    import scaladget.api.Selector._
    import scaladget.tools.JsRxTags._
    import rx._

    // Define a toy case class containing at least a name attribute
    case class MyElement(name: String)

    // Define the option sequence
    val first = MyElement("First element")
    val second = MyElement("Second Element")
    val third = MyElement("Third Element")
    val elements = Seq(first, second, third)


    val selected: Var[MyElement] = Var(elements(1))

    lazy val optionDropDown: Options[MyElement] =
      elements.options(
        1,
        btn_success,
        (m: MyElement) => m.name,
        () => selected() = optionDropDown.content.now.get,
        decorations = Map(first -> glyph_fire, second -> glyph_settings, third -> glyph_flash)
      )

    lazy val fixedTitleOptions: Options[MyElement] = elements.options(
      key = btn_danger,
      naming = (m: MyElement) => m.name,
      onclose = () => println(fixedTitleOptions.content.now.get),
      fixedTitle = Some("Actions")
    )

    val loginInput = bs.input("")(placeholder := "Login")
    val passInput = bs.input("")(placeholder := "Pass", `type` := "password")
    val build: Var[Option[Dropdown[HTMLDivElement]]] = Var(None)


    val formDropDown2 = bs.vForm(width := 200)(
      loginInput.render.withLabel("Login")
    ).dropdown(buttonIcon = glyph_settings, buttonModifierSeq = btn_default)

    val formDropDown3 = bs.vForm(width := 200)(
      passInput.render.withLabel("Pass")
    ).dropdownWithTrigger(bs.glyphSpan(glyph_refresh))

    div(
      hForm(padding := 5)(
        formDropDown2.render,
        formDropDown3.render,
        optionDropDown.selector,
        fixedTitleOptions.selector,
        vForm(width := 200)(loginInput.render,
          button("OK", btn_primary, onclick := {() => {
            build.now.foreach {
              _.close
            }
          }}).render).dropdownWithTrigger(label("Drop", label_warning +++ (height := 30))).render,
        div(
          Rx {
            div(s"Selected: ${selected()}")(padding := 8)
          }).render
      )
    ).render

  }


  val elementDemo = new ElementDemo {
    def title: String = "Dropdown"

    def code: String = sc.source

    def element: Element = sc.value
  }

}
