package de.htwg.se.mastermind.model

case class Row(guess: List[Color], feedback: Feedback):
    def this(num_entries: Int = 4) = this(List.fill(num_entries)(Color.White), Feedback(0,0))
    override def toString: String = 
        feedback.toString + " "*4 + guess.map(color => color.toString).mkString(" ")