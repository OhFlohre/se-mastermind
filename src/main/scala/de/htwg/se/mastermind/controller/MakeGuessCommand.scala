package de.htwg.se.mastermind
package controller

import model.Field
import model.Row
import model.Feedback
import model.Combination
import util.Command
import util.UndoManager

class MakeGuessCommand(solution: Combination, guess: Combination) extends Command[Field]:
  override def doStep(field: Field): Field = field.append(Row(guess, Feedback(solution, guess)))
  override def undoStep(field: Field): Field = field.remove()
  override def redoStep(field: Field): Field = field.append(Row(guess, Feedback(solution, guess)))