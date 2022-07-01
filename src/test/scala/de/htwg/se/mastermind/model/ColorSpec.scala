package de.htwg.se.mastermind.model.field.fieldBaseImpl

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._

class ColorSpec extends AnyWordSpec {
    "Color" when {
        "created Red" should {
            val color = Color.Red
            """have a color code equal to \u001b[31m""" in {
                color.code should be(Console.RED)
            }
            "have a String representation" in {
                color.toString should be(Console.RED + "#" + Console.WHITE)
            }
        }
    }
    "Color" should {
        "have a Method all returning all possible Colors" in {
             Color.all should be(Color.values.toSet)
        }
        "have a method valueOf" in {
            Color.valueOf("Cyan") should be(Color.Cyan)
            Color.valueOf("Blue") should be(Color.Blue)
        }
        "have a method fromOrdinal" in {
            Color.fromOrdinal(0) should be(Color.Red)
            Color.fromOrdinal(2) should be(Color.Green)
        }
        "have a method ordinal" in {
            Color.ordinal(Color.Red) should be(0)
            Color.ordinal(Color.Magenta) should be(4)
        }
    }
}