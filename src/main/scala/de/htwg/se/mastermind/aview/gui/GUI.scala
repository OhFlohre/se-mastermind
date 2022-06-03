package de.htwg.se.mastermind
package aview

import scalafx.Includes._
import scalafx.application.JFXApp3
import scalafx.application.Platform
import scalafx.scene.layout.BorderPane
import scalafx.scene.Scene
import scalafx.scene.web._

import controller.ControllerInterface
import util.Observer


class GUI(controller: ControllerInterface) extends JFXApp3, Observer  {
    controller.add(this)

    override def start(): Unit = {

        stage = new JFXApp3.PrimaryStage {
            title = "Mastermind"
            width = 800
            height = 600
            scene = new Scene {
                fill = Theme.background_dark
                content = new BorderPane {
                    center = new FieldView(controller)
                    bottom = new SelectionView(controller)
                }
            }
        }
    }

    override def update: Unit = {
        Platform.runLater {
            stage.scene = new Scene {
                fill = Theme.background_dark
                content = new BorderPane {
                    center = new FieldView(controller)
                    bottom = new SelectionView(controller)
                }
            }
            stage.show()
        }
  }

}