package de.htwg.se.mastermind

import scala.io.StdIn.readLine
import model.Field
import model.Color

@main def main: Unit = 
    val field = new Field()
    println(field.toString)
    getInputAndPrintLoop(field)


def getInputAndPrintLoop(field: Field): Unit =
    val input = readLine
    parseInput(input) match
    case None => field
    case Some(newfield) =>
        println(newfield)
        getInputAndPrintLoop(newfield)

    def parseInput(input: String): Option[Field] =
        input match
            case "q" => None
            case _ => {
                val chars = input.toCharArray.toList
                val combination = chars.map(char => char match
                    case 'r' => Color.Red
                    case 'b' => Color.Blue
                    case 'g' => Color.Green
                    case 'c' => Color.Cyan
                    case 'm' => Color.Magenta
                    case 'y' => Color.Yellow
                    case _ => Color.White
                ).take(4)
                Some(field.makeGuess(combination))
            }