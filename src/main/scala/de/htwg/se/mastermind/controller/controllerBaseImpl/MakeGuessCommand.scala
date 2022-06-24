package de.htwg.se.mastermind
package controller
package controllerBaseImpl

import model.FieldInterface
import model.fieldBaseImpl.Color
import model.fieldBaseImpl.Row
import model.fieldBaseImpl.Feedback
import util.Command
import util.UndoManager

class MakeGuessCommand(solution: List[Color], guess: List[Color]) extends Command[FieldInterface]:
  override def doStep(field: FieldInterface): FieldInterface = field.append(Row(guess, Feedback(solution, guess)))
  override def undoStep(field: FieldInterface): FieldInterface = field.removeLast()
  override def redoStep(field: FieldInterface): FieldInterface = field.append(Row(guess, Feedback(solution, guess)))