package de.htwg.se.mastermind
package aview

import scalafx.Includes._
import scalafx.application.JFXApp3
import scalafx.application.Platform
import scalafx.scene.layout.BorderPane
import scalafx.scene.Scene
import scalafx.scene.web._

import controller.IController
import util.Observer


class GUI(controller: IController) extends JFXApp3, Observer  {
    controller.add(this)

    override def start(): Unit = {

        stage = new JFXApp3.PrimaryStage {
            title = "Mastermind"
            width = 800
            height = 600
            scene = new MainScene(controller)
        }
    }

    override def update: Unit = {
        Platform.runLater {
            stage.scene = new MainScene(controller)
            stage.show()
        }
  }

}