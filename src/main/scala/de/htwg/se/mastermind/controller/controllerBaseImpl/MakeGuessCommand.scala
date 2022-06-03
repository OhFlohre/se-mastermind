package de.htwg.se.mastermind
package controller
package controllerBaseImpl

import model.FieldInterface
import model.fieldBaseImpl.Row
import model.fieldBaseImpl.Feedback
import model.CombinationInterface
import util.Command
import util.UndoManager

class MakeGuessCommand(solution: CombinationInterface, guess: CombinationInterface) extends Command[FieldInterface]:
  override def doStep(field: FieldInterface): FieldInterface = field.append(Row(guess, Feedback(solution, guess)))
  override def undoStep(field: FieldInterface): FieldInterface = field.remove()
  override def redoStep(field: FieldInterface): FieldInterface = field.append(Row(guess, Feedback(solution, guess)))