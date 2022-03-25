import scala.collection.mutable.ListBuffer

val r = scala.util.Random
val colors = List(Console.GREEN, Console.RED, Console.BLUE, Console.CYAN, Console.MAGENTA, Console.YELLOW)

def generateSolution(colors: List[String]) : ListBuffer[String] = {
    val result = ListBuffer[String]()
    for(i <- 0 to 3) {
        result += colors(r.nextInt(colors.size))
    }
    return result
}

val solution = generateSolution(colors)
