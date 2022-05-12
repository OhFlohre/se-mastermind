package de.htwg.se.mastermind.model

case class Feedback(correctColors: Int, correctPositions: Int):
    override def toString: String = Color.White.code + correctColors + " " + correctPositions