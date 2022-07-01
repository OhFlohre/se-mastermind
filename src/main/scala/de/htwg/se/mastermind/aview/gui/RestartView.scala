package de.htwg.se.mastermind
package aview


import scalafx.scene.layout._
import scalafx.event.EventIncludes._
import scalafx.scene.shape._
import scalafx.scene.text._
import scalafx.scene.control._
import scalafx.util.StringConverter

import controller.IController
import model.field.fieldBaseImpl.{Color,State}


class RestartView(controller: IController) extends HBox {
    this.prefWidth = 800
    this.prefHeight = 100
    this.children = Seq(
        new Text(controller.field.state match
            case State.Won => "You won the game!!!"
            case State.Lost => "You lost the game :("
            case _ => ""
        ),
        new Button{
            text="Restart"
            onMouseClicked = handle{
                controller.doAndPublish(controller.createField)
            }
        }
    )
}