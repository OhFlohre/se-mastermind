package de.htwg.se.mastermind.model

case class Feedback(correctPositions: Int, correctColors: Int):
    override def toString: String = Color.White.code + correctPositions + " " + correctColors

object Feedback {
    def apply(solution: Combination, guess: Combination) : Feedback = 
        val (correctPosition, correctColors) = generateFromGuess(solution, guess)
        new Feedback(correctPosition, correctColors)

    def generateFromGuess(solution: Combination, guess: Combination): (Int,Int) = 
        val solutionCopy = solution.copy()
        var correctPositions = 0
        var correctColors = 0

        guess.data.zipWithIndex.foreach{case (color, i) => 
            if(solutionCopy.data.contains(color))
                if(i == solution.data.indexOf(color)) correctPositions = correctPositions + 1
                else correctColors = correctColors + 1
        }

        (correctPositions, correctColors)


    def getCorrectPositions(solution: Combination, guess: Combination): Int = solution.data.zip(guess.data).count((a,b) => a == b)
    def getCorrectColors(solution: Combination, guess: Combination): Int =
        var checked: Set[Int] = Set()
        var result : List[Int] = List()
        for (i <- 0 until guess.data.length)
            val j = solution.data.indexOf(guess.data(i))
            if(i == j) checked = checked+j
            else if(j != -1 && !checked.contains(j)) 
                result = result:+i
                checked = checked+j
            
        result.length

}
