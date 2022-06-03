package de.htwg.se.mastermind
package aview


import scalafx.scene.layout._
import scalafx.scene.shape._
import scalafx.scene.paint.Color._

import controller.Controller
import model.Feedback


class FeedbackView(feedback: Feedback) extends GridPane {
    val correctPositionPins = List.fill(feedback.correctPositions)(new Circle{
        radius = 10
        fill = Red
    })
    val correctColorPins = List.fill(feedback.correctColors)(new Circle{
        radius = 10
        fill = Red
    })

    println(correctColorPins)
    println(correctColorPins)
    //this.add(correctPositionPins)
    //this.add(correctPositionPins)

}