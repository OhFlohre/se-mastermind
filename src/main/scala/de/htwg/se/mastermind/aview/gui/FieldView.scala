package de.htwg.se.mastermind
package aview


import scalafx.scene.layout._
import scalafx.scene.control._

import controller.Controller
import model.Color


class FieldView(controller: Controller) extends ScrollPane{
    this.setStyle("-fx-background: " + Theme.background)
    this.prefWidth = 800
    this.prefHeight = 500
    this.content = new VBox{
        children = controller.field.rows.map(row => {
            new RowView(row)
        }).toSeq
    }

}