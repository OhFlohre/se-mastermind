package de.htwg.se.mastermind.model

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
        "created White" should {
            val color = Color.White
            """have a color code equal to \u001b[37m""" in {
                color.code should be(Console.WHITE)
            }
            "have a String representation" in {
                color.toString should be(Console.WHITE + "#" + Console.WHITE)
            }
        }
    }
    "Color" should {
        "have a Method all returning all possible Colors" in {
             Color.all should be(Color.values.toSet)
        }
        "have a method valueOf" in {
            Color.valueOf("Cyan") should be(Color.Cyan)
            Color.valueOf("White") should be(Color.White)
        }
        "have a method fromOrdinal" in {
            Color.fromOrdinal(0) should be(Color.Red)
            Color.fromOrdinal(6) should be(Color.White)
        }
        "have a method ordinal" in {
            Color.ordinal(Color.Red) should be(0)
            Color.ordinal(Color.White) should be(6)
        }
    }
}