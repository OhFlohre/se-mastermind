package de.htwg.se.mastermind
package aview

import scala.io.StdIn.readLine

import util.Observer
import controller.ControllerInterface
import model.fieldBaseImpl.Color
import scala.util.Success
import scala.util.Failure

class TUI(controller: ControllerInterface) extends Observer:
    controller.add(this)

    def run =
        println(controller.field.toString)
        inputLoop()
    
    def inputLoop(): Unit =
        parseInput(readLine) match
            case None =>
            case Some(guess) => controller.doAndPublish(controller.makeGuess, guess)
        inputLoop()
    
    def parseInput(input: String): Option[List[Color]] =
        input match
            case "a" => controller.doAndPublish(controller.undo); None
            case "d" => controller.doAndPublish(controller.redo); None
            case "q" => None
            case _ => {
                val chars = input.toCharArray.toList
                val guess = chars.map(char => char match
                case 'r' => Color.Red
                case 'b' => Color.Blue
                case 'g' => Color.Green
                case 'c' => Color.Cyan
                case 'm' => Color.Magenta
                case 'y' => Color.Yellow
                ).take(4)

                if(guess.length < 4) None
                else Some(guess)
            }
    
    override def update = println(controller.field.toString)