package de.htwg.se.mastermind
package model
package fieldBaseImpl

case class Row(guess: List[Color], feedback: Feedback) extends RowInterface:
    override def toString: String = 
        feedback.toString + " "*4 + guess.mkString(" ")