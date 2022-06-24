package de.htwg.se.mastermind
package model
package fieldBaseImpl


import com.google.inject.Inject


case class Row (guess: List[Color], feedback: Feedback):
    override def toString: String = 
        feedback.toString + " "*4 + guess.mkString(" ")