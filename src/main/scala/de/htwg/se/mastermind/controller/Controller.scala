package de.htwg.se.mastermind
package controller

import model.Field
import model.Row
import model.Feedback
import model.Color
import util.Observable

case class Controller(var field: Field) extends Observable:
    def makeGuess(guess: List[Color]) =
        field = field.append(Row(guess, Feedback(0,0)))
        notifyObservers

    override def toString: String = field.toString