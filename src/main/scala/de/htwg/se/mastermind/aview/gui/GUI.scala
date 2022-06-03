package de.htwg.se.mastermind
package aview

import scalafx.Includes._
import scalafx.application.JFXApp3
import scalafx.application.Platform
import scalafx.scene.layout.BorderPane
import scalafx.scene.Scene
import scalafx.scene.web._

import controller.Controller
import util.Observer


class GUI(controller: Controller) extends JFXApp3, Observer  {
    controller.add(this)

    override def start(): Unit = {

        stage = new JFXApp3.PrimaryStage {
            title = "Mastermind"
            width = 600
            height = 450
            scene = new Scene {
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
                content = new BorderPane {
                    center = new FieldView(controller)
                    bottom = new SelectionView(controller)
                }
            }
            stage.show()
        }
  }

}