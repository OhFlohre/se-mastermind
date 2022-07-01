package de.htwg.se.mastermind
package aview

import controller.controllerBaseImpl.Controller
import model.field.fieldBaseImpl.{Field,Color}

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._

class ControllerSpec extends AnyWordSpec {
    "Tui" should {
        val field = Field()
        val controller = Controller(field)
        val tui = TUI(controller)

        "parse input rrgg to Some[List[Color]]" in {
            val input = "rrgg"
            val guess = List(Color.Red, Color.Red, Color.Green, Color.Green)

            tui.parseInput(input) should equal(Some(guess))
        }

        "parse input rr to None" in {
            val input = "rr"
            val result = tui.parseInput(input) should be(None)
        }
    }
}