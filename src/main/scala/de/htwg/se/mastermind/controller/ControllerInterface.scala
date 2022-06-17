package de.htwg.se.mastermind
package controller


import util.Observable
import model.fieldBaseImpl.Color
import model.FieldInterface


trait ControllerInterface extends Observable {
    var field : FieldInterface
    def makeGuess(guess: List[Color]) : FieldInterface
    def undo: FieldInterface
    def redo: FieldInterface
    def toString: String

    def doAndPublish(func: List[Color] => FieldInterface, guess: List[Color]): Unit
    def doAndPublish(func: => FieldInterface): Unit
}