package de.htwg.se.mastermind
package controller


import util.Observable
import model.FieldInterface
import model.RowInterface
import model.CombinationInterface


trait ControllerInterface extends Observable {
    var field : FieldInterface
    def makeGuess(guess: CombinationInterface) : FieldInterface
    def undo: FieldInterface
    def redo: FieldInterface
    def toString: String

    def doAndPublish(func: CombinationInterface => FieldInterface, guess: CombinationInterface): Unit
    def doAndPublish(func: => FieldInterface): Unit
}