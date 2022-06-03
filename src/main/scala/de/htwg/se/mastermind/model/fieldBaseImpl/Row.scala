package de.htwg.se.mastermind
package model
package fieldBaseImpl

case class Row(guess: CombinationInterface, feedback: Feedback) extends RowInterface:
    override def toString: String = 
        feedback.toString + " "*4 + guess.data.mkString(" ")