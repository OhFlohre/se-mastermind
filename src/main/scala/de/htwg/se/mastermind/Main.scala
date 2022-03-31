val r = scala.util.Random
val eol = System.lineSeparator


@main def main: Unit = 
    val colors = List(Console.GREEN, Console.RED, Console.BLUE, Console.CYAN, Console.MAGENTA, Console.YELLOW)
    val solution = generateSolution(colors)
    println(row(solution))

def generateSolution(colors: List[String]) = 
    for(i <- Vector.range(0,4)) yield colors(r.nextInt(colors.size))

def row(colors: Vector[String]): String = {
    val dots = for(color <- colors) yield dot(color)
    val result = StringBuilder("")
    for(line <- dots.transpose; i <- 0 until line.size) {
        result.append(line(i))
        if(i == 3) result.append(eol)
    }

    result.toString
}   

def dot(color : String) = Vector(color + "  ###  ", color + " ##### ", color + "  ###  ")