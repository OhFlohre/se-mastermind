package de.htwg.se.mastermind
package aview

import controller.Controller
import model.Field
import model.Color

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._

class ControllerSpec extends AnyWordSpec {
    "Tui" should {
        val field = new Field()
        val controller = Controller(field)
        val tui = TUI(controller)

        "parse input rrgg to Some(List[Color.Red, Color.Red, Color.Green, Color.Green])" in {
            val input = "rrgg"
            val guess = List(Color.Red, Color.Red, Color.Green, Color.Green)

            tui.parseInput(input) should equal(Some(guess))
        }

        "parse input rr to None" in {
            val input = "rr"
            tui.parseInput(input) should equal(None)
        }
    }
}