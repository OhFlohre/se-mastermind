package de.htwg.se.mastermind.model

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._

class FieldSpec extends AnyWordSpec {
    "Field" when {
        "created empty" should {
            val field = new Field()
            val eol = sys.props("line.separator")
            "have 8 rows" in {
                field.rows.length should be(8) 
            }

            "have a String representation" in {
                field.toString should be (field.rows.map(_.toString + eol).mkString)
            }
        }
        "created with 12 tries" should {
            val field = new Field(12)
            "have 12 rows" in {
                field.rows.length should be(12)
            }
        }
    }
}