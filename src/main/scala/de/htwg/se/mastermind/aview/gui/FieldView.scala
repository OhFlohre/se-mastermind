package de.htwg.se.mastermind
package aview


import scalafx.scene.layout._
import scalafx.scene.text._

import controller.Controller
import model.Color


class FieldView(controller: Controller) extends VBox {
    this.children = controller.field.rows.map(row => {
        new RowView(row)
    }).toSeq

}