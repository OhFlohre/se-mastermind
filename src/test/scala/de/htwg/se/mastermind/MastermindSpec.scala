package de.htwg.se.mastermind

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._

class MastermindSpec extends AnyWordSpec {
  "colors should be a List including only ANSI color codes" in {
    colors foreach(color => color should fullyMatch regex """\[\d\d(;\d)?m""")
  }
  "dot should return a colored dot as a Vector('  ###  ',' ##### ','  ###  ')" in {
    val redDot = dot(Console.RED)
    redDot(0) should be(Console.RED + "  ###  ")
    redDot(1) should be(Console.RED + " ##### ")
    redDot(2) should be(Console.RED + "  ###  ")
  }
  "dots should return a Vector of colored dots" in {
    val colors = Vector(Console.RED,Console.RED, Console.BLUE, Console.YELLOW)
    val testDots = dots(colors)
    for(i <- 0 until testDots.size) testDots(i) should equal(dot(colors(i)))
  }
  "dots should have a length of 4" in{
    val colors = Vector(Console.RED,Console.RED, Console.BLUE, Console.YELLOW)
    dots(colors) should have length 4
  }
  "row should be 4 dots concatinated together" in {
    val colors = Vector(Console.RED,Console.RED, Console.BLUE, Console.YELLOW)
    val testRow = row(colors)
    testRow should be(
      colors(0) + "  ###  " + colors(1) +"  ###  " + colors(2) + "  ###  " + colors(3) + "  ###  " + eol +
      colors(0) + " ##### " + colors(1) +" ##### " + colors(2) + " ##### " + colors(3) + " ##### " + eol +
      colors(0) + "  ###  " + colors(1) +"  ###  " + colors(2) + "  ###  " + colors(3) + "  ###  " + eol
    )
  }
  "generateSolution generates a Vector of colors of length 4" in {
    val colors = List(Console.GREEN, Console.RED, Console.BLUE, Console.CYAN, Console.MAGENTA, Console.YELLOW)
    generateSolution(colors) should have length 4
  }
}