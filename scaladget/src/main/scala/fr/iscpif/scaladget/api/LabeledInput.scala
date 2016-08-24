package fr.iscpif.scaladget.api

/*
 * Copyright (C) 12/05/16 // mathieu.leclaire@openmole.org
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

import java.util.UUID

import fr.iscpif.scaladget.stylesheet.{all => sheet}
import fr.iscpif.scaladget.api.{BootstrapTags => bs}
import scalatags.JsDom.all._
import sheet._

class LabeledInput(title: String, default: String, pHolder: String, labelStyle: ModifierSeq, inputStyle: ModifierSeq) {


  val uuid = UUID.randomUUID().toString
  val lab = label(title)(labelStyle +++ (sheet.paddingRight(5)), `for` := uuid).render

  val inp = bs.input(default)(
    id := uuid,
    `type` := "text",
    formControl,
    placeholder := pHolder,
    inputStyle
  ).render


  def setDefault(v: String) = inp.value = v

  def value = inp.value

}