package de.htwg.se.mastermind.model

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._

class FieldSpec extends AnyWordSpec {
    "Field" when {
        "created empty" should {
            val eol = sys.props("line.separator")
            val field = new Field()

            "have 0 rows" in {
                field.rows.length should be(0) 
            }

            "have an empty String representation" in {
                field.toString should be ("")
            }
        }
        "created with a List of rows" should {
            val guess1 = new Combination(List(Color.Red, Color.Red, Color.Cyan, Color.Blue))
            val guess2 = new Combination(List(Color.Yellow, Color.Magenta, Color.Cyan, Color.Red))
            val field = new Field(List(Row(guess1, Feedback(0,0)), Row(guess2, Feedback(0,0))))

            "have a method append" in {
                val guess3 = new Combination(List(Color.Magenta, Color.Magenta, Color.Cyan, Color.Red))
                val newField = field.append(Row(guess3, Feedback(0,0)))
                newField.rows.length should be(3)
            }
            "have a String representation" in {
                val eol = sys.props("line.separator")
                field.toString should equal (
                    Color.White.code + "0 0    " + Color.Red.toString + " " + Color.Red.toString + " " + Color.Cyan.toString + " " + Color.Blue.toString + eol +
                    Color.White.code + "0 0    " + Color.Yellow.toString + " " + Color.Magenta.toString + " " + Color.Cyan.toString + " " + Color.Red.toString
                )
            }
        }
    }
}