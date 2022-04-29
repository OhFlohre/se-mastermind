package de.htwg.se.mastermind.model

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._

class RowSpec extends AnyWordSpec {
    "Row" when {
        "created empty" should {
            val row = new Row()
            "have a Guess as a List of length 4 containing only Color.White" in {
                row.guess should be(List(Color.White, Color.White, Color.White, Color.White))
            }
            "have a Feedback with 0 0" in {
                row.feedback.correctColors should be(0)
                row.feedback.correctColors should be(0)
            }
            "have a String representation" in {
                row.toString should be(Color.White.code + "0 0    " + (Color.White.toString + " ")*3 + Color.White.toString)
            }
        }
        "created with a fixed length of 5" should {
            val row = new Row(5)
            "have a Guess as a List of length 5 containing only Color.White" in {
                row.guess should be(List(Color.White, Color.White, Color.White, Color.White, Color.White))
            }
        }
        "created with Guess and Feedback" should {
            val row = new Row(List(Color.Red, Color.Green, Color.Cyan, Color.Red), Feedback(2,2))
            "have a String representation" in {
                row.toString should be(Color.White.code + "2 2    " + Color.Red.toString + " " + Color.Green.toString + " " + Color.Cyan.toString + " " + Color.Red.toString)
            }
        }
    }
}