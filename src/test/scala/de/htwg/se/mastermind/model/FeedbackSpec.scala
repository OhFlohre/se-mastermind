package de.htwg.se.mastermind.model.field.fieldBaseImpl

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._

class FeedbackSpec extends AnyWordSpec {
    "Feedback" when {
        "created with 1 and 3" should {
            val fb = Feedback(1,3)

            "have correctPositions = 1" in {
                fb.correctPositions should be(1)
            }
            "have correctColors = 3" in {
                fb.correctColors should be(3)
            }
            "have a String representation" in {
                fb.toString should be(Console.WHITE + "1 3")
            }
        }
        "created with a guess which is equal to solution" should {
            val solution = List(Color.Red,Color.Red,Color.Cyan,Color.Magenta)
            val fb = Feedback(solution, solution)

            "have correctPositions = 4" in {
                fb.correctPositions should be(4)
            }

            "have correctColors = 0" in {
                fb.correctColors should be(0)
            }
        }
        "created with a guess which has no similarities to solution" should {
            val solution = List(Color.Red,Color.Red,Color.Cyan,Color.Magenta)
            val guess = List(Color.Yellow, Color.Green, Color.Blue,Color.Yellow)
            val fb = Feedback(solution, guess)

            "have correctPositions = 0" in {
                fb.correctPositions should be(0)
            }

            "have correctColors = 0" in {
                fb.correctColors should be(0)
            }
        }
        "created with a guess which partially matches solution" should {
            val solution = List(Color.Red,Color.Red,Color.Cyan,Color.Magenta)
            val guess = List(Color.Red, Color.Cyan, Color.Blue,Color.Red)
            val fb = Feedback(solution, guess)

            "have correctPositions = 1" in {
                fb.correctPositions should be(1)
            }
            "have correctColors = 2" in {
                fb.correctColors should be(2)
            }
        }
    }
}