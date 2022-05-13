package de.htwg.se.mastermind
package aview

import scala.io.StdIn.readLine

import util.Observer
import controller.Controller
import model.Color

class TUI(controller: Controller) extends Observer:
    controller.add(this)

    def run =
        println(controller.field.toString)
        inputLoop()
    
    def inputLoop(): Unit =
        parseInput(readLine) match
            case None => println("invalid input")
            case Some(guess) => controller.doAndPublish(controller.makeGuess, guess)
        inputLoop()
    
    def parseInput(input: String): Option[List[Color]] = 
        input match
            case _ => {
                val chars = input.toCharArray.toList
                val guess = chars.map(char => char match
                case 'r' => Color.Red
                case 'b' => Color.Blue
                case 'g' => Color.Green
                case 'c' => Color.Cyan
                case 'm' => Color.Magenta
                case 'y' => Color.Yellow
                case _ => Color.White
                ).take(4)

                if(guess.length < 4) None
                else Some(guess)
            }
    
    override def update = println(controller.field.toString)