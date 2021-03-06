package scaladget.mapping.bootstrap

/*
 * Copyright (C) 18/08/16 // mathieu.leclaire@openmole.org
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


import org.scalajs.dom.Element

import scala.scalajs.js
import scala.scalajs.js.annotation._
import scala.scalajs.js.Dynamic.{literal => lit}


@JSGlobal
@js.native
class Modal(element: Element) extends js.Object {

  def show(): Unit = js.native
  def hide(): Unit = js.native
}


@JSGlobal
@js.native
class Popover(element: Element, options: js.Dynamic = lit()) extends js.Object {

  def show(): Unit = js.native
  def hide(): Unit = js.native
  def toggle(): Unit = js.native
}

@JSGlobal
@js.native
class Tooltip(element: Element, options: js.Dynamic = lit()) extends js.Object {

  def show(): Unit = js.native
  def hide(): Unit = js.native
}

@JSGlobal
@js.native
class Collapse(element: Element, options: js.Dynamic = lit()) extends js.Object {

  def show(): Unit = js.native
  def hide(): Unit = js.native
  def toggle(): Unit = js.native
}
