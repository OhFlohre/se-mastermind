package de.htwg.se.mastermind
package model
package fieldBaseImpl

case class Feedback(correctPositions: Int, correctColors: Int) extends FeedbackInterface:
    override def toString: String = Color.White.code + correctPositions + " " + correctColors

object Feedback {
    def apply(solution: CombinationInterface, guess: CombinationInterface) : Feedback = 
        val (correctPosition, correctColors) = generateFromGuess(solution, guess)
        new Feedback(correctPosition, correctColors)

    def generateFromGuess(solution: CombinationInterface, guess: CombinationInterface): (Int,Int) = 
        val solutionCopy = solution
        var correctPositions = 0
        var correctColors = 0

        guess.data.zipWithIndex.foreach{case (color, i) => 
            if(solutionCopy.data.contains(color))
                if(i == solution.data.indexOf(color)) correctPositions = correctPositions + 1
                else correctColors = correctColors + 1
        }

        (correctPositions, correctColors)
}
