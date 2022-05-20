package de.htwg.se.mastermind.model

case class Row(guess: Combination, feedback: Feedback):
    override def toString: String = 
        feedback.toString + " "*4 + guess.data.mkString(" ")