package de.htwg.se.mastermind
package controller
package controllerBaseImpl

import model.FieldInterface
import model.CombinationInterface
import model.fieldBaseImpl.Row
import model.fieldBaseImpl.Combination
import model.fieldBaseImpl.Feedback
import model.fieldBaseImpl.Color
import util.Observable
import util.UndoManager
import util.Command

case class Controller(var field: FieldInterface) extends ControllerInterface:
    val undoManager = new UndoManager[FieldInterface]
    val solution = new Combination(List(Color.Red, Color.Cyan, Color.Red, Color.Yellow))

    def doAndPublish(func: CombinationInterface => FieldInterface, guess: CombinationInterface): Unit =
        field = func(guess)
        notifyObservers

    def doAndPublish(func: => FieldInterface): Unit =
        field = func
        notifyObservers
    
    def makeGuess(guess: List[Color]): FieldInterface =
        undoManager.doStep(field, MakeGuessCommand(solution, Combination(guess)))
        field.append(Row(guess, Feedback(solution,guess)))

    def undo: FieldInterface = undoManager.undoStep(field)
    def redo: FieldInterface = undoManager.redoStep(field)

    override def toString: String = field.toString