package de.htwg.se.mastermind
package controller

import model.Field
import model.Row
import model.Combination
import model.Feedback
import model.Color
import util.Observable
import util.UndoManager
import util.Command

case class Controller(var field: Field) extends Observable:
    val undoManager = new UndoManager[Field]
    val solution = new Combination(List(Color.Red, Color.Cyan, Color.Red, Color.Yellow))

    def doAndPublish(func: Combination => Field, guess: Combination): Unit =
        field = func(guess)
        notifyObservers

    def doAndPublish(func: => Field) =
        field = func
        notifyObservers
    
    def makeGuess(guess: Combination): Field =
        undoManager.doStep(field, MakeGuessCommand(solution, guess))
        field.append(Row(guess, Feedback(solution,guess)))

    def undo: Field = undoManager.undoStep(field)
    def redo: Field = undoManager.redoStep(field)

    override def toString: String = field.toString