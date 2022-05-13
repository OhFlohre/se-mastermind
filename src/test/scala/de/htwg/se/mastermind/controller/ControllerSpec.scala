package de.htwg.se.mastermind
package controller

import model.Row
import model.Color
import model.Field
import model.Feedback

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._

class ControllerSpec extends AnyWordSpec {
    "Controller" should {
        val row1 = new Row(List(Color.Red, Color.Red, Color.Cyan, Color.Blue), Feedback(0,0))
        val row2 = new Row(List(Color.Yellow, Color.Magenta, Color.Cyan, Color.Red), Feedback(0,0))
        val field = new Field(List(row1,row2))
        val controller = Controller(field)
        "append a row to field when a guess is made" in {
            val guess = List(Color.Red, Color.Red, Color.Cyan, Color.Blue)
            val field = controller.makeGuess(guess)
            field.rows(2).guess should equal(guess)
        }
        "have a String representation" in {
            controller.toString should equal(field.toString)
        }
    }
}