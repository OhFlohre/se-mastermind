package de.htwg.se.mastermind
package aview


import scalafx.scene.layout._
import scalafx.scene.shape._
import scalafx.geometry._
import scalafx.scene.paint.Color._

import model.FeedbackInterface


class FeedbackView(feedback: FeedbackInterface) extends GridPane {
    val correctPositionPins = List.fill(feedback.correctPositions)(new Circle{
        radius = 10
        fill = Red
    })
    val correctColorPins = List.fill(feedback.correctColors)(new Circle{
        radius = 10
        fill = White
    })

    val pins = correctPositionPins ++ correctColorPins
    this.padding = Insets(5)
    this.hgap = 5
    this.vgap = 5
    this.minWidth = 60
    pins.zipWithIndex.foreach { case (pin, i) =>
        this.add(pin, i % 2, i / 2)
    }
    

}