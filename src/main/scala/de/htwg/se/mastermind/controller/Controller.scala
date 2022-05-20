package de.htwg.se.mastermind
package controller

import model.Field
import model.Row
import model.Combination
import model.Feedback
import model.Color
import util.Observable

case class Controller(var field: Field) extends Observable:
    def doAndPublish(func: Combination => Field, guess: Combination): Unit =
        field = func(guess)
        notifyObservers

    def makeGuess(guess: Combination) =
        field.append(Row(guess, Feedback(0,0)))

    override def toString: String = field.toString