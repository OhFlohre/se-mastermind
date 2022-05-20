package de.htwg.se.mastermind
package controller

import model.Row
import model.Color
import model.Field
import model.Feedback
import model.Combination

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._

class ControllerSpec extends AnyWordSpec {
    "Controller" should {
        val guess1 = new Combination(List(Color.Red, Color.Red, Color.Cyan, Color.Blue))
        val guess2 = new Combination(List(Color.Yellow, Color.Magenta, Color.Cyan, Color.Red))
        val field = new Field(List(Row(guess1, Feedback(0,0)), Row(guess2, Feedback(0,0))))
        val controller = Controller(field)
        "append a row to field when a guess is made" in {
            val guess = Combination(List(Color.Red, Color.Red, Color.Cyan, Color.Blue))
            val field = controller.makeGuess(guess)
            field.rows(2).guess should equal(guess)
        }
        "have a String representation" in {
            controller.toString should equal(field.toString)
        }
    }
}