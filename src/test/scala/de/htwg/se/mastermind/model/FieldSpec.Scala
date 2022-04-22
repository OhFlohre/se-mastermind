package de.htwg.se.mastermind.model

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._

class FieldSpec extends AnyWordSpec {
    "Field" when {
        "created empty" should {
            val field = new Field()
            val eol = sys.props("line.separator")
            "have 0 rows" in {
                field.rows.length should be(0) 
            }

            "have an empty String representation" in {
                field.toString should be ("")
            }
        }
        "created with a List of rows" should {
            val row1 = new Row(List(Color.Red, Color.Red, Color.Cyan, Color.Blue), Feedback(0,0))
            val row2 = new Row(List(Color.Yellow, Color.Magenta, Color.Cyan, Color.Red), Feedback(0,0))
            val field = new Field(List(row1,row2))

            "have a method makeGuess" in {
                val combination = List(Color.Magenta, Color.Magenta, Color.Cyan, Color.Red)
                val newField = field.makeGuess(combination)
                newField.rows.length should be(3)
            }
        }
    }
}