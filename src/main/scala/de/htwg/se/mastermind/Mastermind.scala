package de.htwg.se.mastermind

val eol = sys.props("line.separator")
val colors = List(Console.GREEN, Console.RED, Console.BLUE, Console.CYAN, Console.MAGENTA, Console.YELLOW)

def generateSolution(colors: List[String]) = 
    val r = scala.util.Random
    for(i <- Vector.range(0,4)) yield colors(r.nextInt(colors.size))  

def dot(color : String) = Vector(color + "  ###  ", color + " ##### ", color + "  ###  ")
def dots(colors: Vector[String]) = for(color <- colors) yield dot(color)

def row(colors: Vector[String]): String = 
    (for(line <- dots(colors).transpose; i <- 0 until line.size)
        yield line(i) + (if i == 3 then eol else "")
    ).mkString

@main def main: Unit = 
    val solution = generateSolution(colors)
    println(row(solution))