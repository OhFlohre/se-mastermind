package de.htwg.se.mastermind
package model
package field
package fieldBaseImpl


case class Feedback (correctPositions: Int, correctColors: Int) extends IFeedback:
    override def toString: String = Console.WHITE + correctPositions + " " + correctColors

object Feedback {
    def apply(solution: List[Color], guess: List[Color]) : IFeedback = 
        val (correctPosition, correctColors) = generateFromGuess(solution, guess)
        Feedback(correctPosition, correctColors)

    def generateFromGuess(solution: List[Color], guess: List[Color]): (Int,Int) = 
        val solutionCopy = solution
        var correctPositions = 0
        var correctColors = 0

        guess.zipWithIndex.foreach{case (color, i) => 
            if(solutionCopy.contains(color))
                if(i == solution.indexOf(color)) correctPositions = correctPositions + 1
                else correctColors = correctColors + 1
        }

        (correctPositions, correctColors)
}
