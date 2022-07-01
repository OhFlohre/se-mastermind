package de.htwg.se.mastermind
package controller
package controllerBaseImpl

import model.field.fieldBaseImpl.{Color,Field,Feedback, Row}

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._

class ControllerSpec extends AnyWordSpec {
    "Controller" should {
        val guess1 = List(Color.Red, Color.Red, Color.Cyan, Color.Blue)
        val guess2 = List(Color.Yellow, Color.Magenta, Color.Cyan, Color.Red)
        val field = Field(List(Row(guess1, Feedback(0,0)), Row(guess2, Feedback(0,0))))
        val controller = Controller(field)
        
        "append a row to field when a guess is made" in {
            val guess = List(Color.Red, Color.Red, Color.Cyan, Color.Blue)
            val field = controller.makeGuess(guess)
            field.rows(2).guess should equal(guess)
        }
        "have a String representation" in {
            controller.toString should equal(field.toString)
        }
        "have an empty field after calling createField" in {
            val field = controller.createField
            field.rows.size should be(0)
        }
    }
}