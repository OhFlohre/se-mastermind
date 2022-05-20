package de.htwg.se.mastermind.model

case class Feedback(correctColors: Int, correctPositions: Int):
    override def toString: String = Color.White.code + correctColors + " " + correctPositions

object Feedback {
    def apply(solution: Combination, guess: Combination) : Feedback = 
        new Feedback(getCorrectColors(solution, guess), getCorrectPositions(solution, guess))

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
