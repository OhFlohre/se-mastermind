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
        var usedIndecies: List[Int] = List()
        var correctPositions = 0
        var correctColors = 0

        for (i <- 0 until 4) {
            if (guess(i) == solution(i))
                correctPositions += 1
                usedIndecies = usedIndecies:+i
            else if (guess.contains(solution(i)) && !usedIndecies.contains(i)) 
                correctColors +=1
                usedIndecies = usedIndecies:+i
        }

        (correctPositions,correctColors)
}
