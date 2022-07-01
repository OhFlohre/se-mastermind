package de.htwg.se.mastermind.model.field.fieldBaseImpl

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._

class RowSpec extends AnyWordSpec {
    "Row" should {
        "created with Guess and Feedback" should {
            val guess = List(Color.Red, Color.Green, Color.Cyan, Color.Red)
            val feedback = new Feedback(2,2)
            val row = new Row(guess, feedback)
            "have a String representation" in {
                row.toString should be(Console.WHITE + "2 2    " + Color.Red.toString + " " + Color.Green.toString + " " + Color.Cyan.toString + " " + Color.Red.toString)
            }
        }
    }
}