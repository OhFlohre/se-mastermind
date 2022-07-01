package de.htwg.se.mastermind
package model
package field
package fieldBaseImpl


case class Row (guess: List[Color], feedback: IFeedback) extends IRow:
    override def toString: String = 
        feedback.toString + " "*4 + guess.mkString(" ")