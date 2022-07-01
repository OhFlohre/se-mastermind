package de.htwg.se.mastermind
package aview


import scalafx.Includes._
import scalafx.application.JFXApp3
import scalafx.application.Platform
import scalafx.scene.layout.BorderPane
import scalafx.scene.Scene
import scalafx.scene.web._

import controller.IController
import model.field.fieldBaseImpl.State
import util.Observer


class MainScene(controller: IController) extends Scene {
    fill = Theme.background_dark
    content = new BorderPane {
        center = new FieldView(controller)
        bottom = controller.field.state match
            case State.Playing => new SelectionView(controller)
            case _ => new RestartView(controller)
    }
}