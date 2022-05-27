package de.htwg.se.mastermind
package util

import org.scalatest.matchers.should.Matchers._
import org.scalatest.wordspec.AnyWordSpec

class IncrementCommand extends Command[Int]:
    override def doStep(state: Int): Int = state + 1
    override def undoStep(state: Int): Int = state - 1
    override def redoStep(state: Int): Int = state + 1

class CommandSpec extends AnyWordSpec {
    "Command" should {
        val command = new IncrementCommand
        "have a do step" in {
            command.doStep(1) should be(2)
            command.doStep(24) should be(25)
        }
        "have an undo step" in {
            command.undoStep(2) should be(1)
            command.undoStep(4) should be(3)
        }
        "have a redo step" in {
            command.redoStep(1) should be(2)
            command.redoStep(42) should be(43)
        }
    }
}


class UndoManagerSpec extends AnyWordSpec {

  "UndoManager" should {
    val undoManager = new UndoManager[Int]
    val command = new IncrementCommand
    var state = 1

    "have a do" in {
      state = undoManager.doStep(state, command)
      state should be(2)
    }

    "have an undo" in {
        state = undoManager.undoStep(state)
        state should be(1)
    }

    "have a redo" in {
        state = undoManager.redoStep(state)
        state should be(2)
    }
  }
}