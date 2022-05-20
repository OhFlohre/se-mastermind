package de.htwg.se.mastermind
package model

import model.Combination
import model.Color

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._

class ControllerSpec extends AnyWordSpec {
    "Combination" should {
        val colors = List(Color.Red, Color.Red, Color.Yellow, Color.Cyan)
        val combination = Combination(colors)
        "have a List of Colors" in {
            combination.data should equal(colors)
        }
    }   
}