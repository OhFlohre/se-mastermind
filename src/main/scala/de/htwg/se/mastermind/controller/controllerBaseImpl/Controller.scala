package de.htwg.se.mastermind
package controller
package controllerBaseImpl


import com.google.inject.Inject

import model.FieldInterface
import model.fieldBaseImpl.Row
import model.fieldBaseImpl.Feedback
import model.fieldBaseImpl.Color
import util.Observable
import util.UndoManager
import util.Command

case class Controller @Inject() (var field: FieldInterface) extends ControllerInterface:
    val undoManager = new UndoManager[FieldInterface]
    val solution = List(Color.Red, Color.Cyan, Color.Red, Color.Yellow)

    def doAndPublish(func: List[Color] => FieldInterface, guess: List[Color]): Unit =
        field = func(guess)
        notifyObservers

    def doAndPublish(func: => FieldInterface): Unit =
        field = func
        notifyObservers
    
    def makeGuess(guess: List[Color]): FieldInterface =
        undoManager.doStep(field, MakeGuessCommand(solution, guess))
        field.append(Row(guess, Feedback(solution,guess)))

    def undo: FieldInterface = undoManager.undoStep(field)
    def redo: FieldInterface = undoManager.redoStep(field)

    override def toString: String = field.toString