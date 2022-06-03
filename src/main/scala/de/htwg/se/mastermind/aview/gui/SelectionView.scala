package de.htwg.se.mastermind
package aview


import scalafx.scene.layout._
import scalafx.event.EventIncludes._
import scalafx.scene.shape._
import scalafx.scene.text._
import scalafx.scene.control._
import scalafx.util.StringConverter

import controller.Controller
import model.Color
import model.Combination


class SelectionView(controller: Controller) extends HBox {

    val selector1 = new ComboBox[Color](Color.all.toSeq) {
        converter = StringConverter.toStringConverter((color: Color) => color.name)
        selectionModel.value.selectFirst()
    }
    val selector2 = new ComboBox(Color.all.toList) {
        converter = StringConverter.toStringConverter((color: Color) => color.name)
        selectionModel.value.selectFirst()
    }
    val selector3 = new ComboBox(Color.all.toList) {
        converter = StringConverter.toStringConverter((color: Color) => color.name)
        selectionModel.value.selectFirst()
    }
    val selector4 = new ComboBox(Color.all.toList) {
        converter = StringConverter.toStringConverter((color: Color) => color.name)
        selectionModel.value.selectFirst()
    }

    this.children = Seq(
        selector1,
        selector2,
        selector3,
        selector4,
        new Button{
            text="Submit"
            onMouseClicked = handle{
                println(selector1.value.apply())
                controller.doAndPublish(controller.makeGuess, Combination(List(
                    selector1.value.apply(),
                    selector2.value.apply(),
                    selector3.value.apply(),
                    selector4.value.apply())))
            }
        }
    )
}