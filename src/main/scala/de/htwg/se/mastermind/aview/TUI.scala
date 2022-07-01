package de.htwg.se.mastermind
package aview

import scala.io.StdIn.readLine

import util.Observer
import controller.IController
import model.field.fieldBaseImpl.{Color, State}
import scala.util.Success
import scala.util.Failure

class TUI(controller: IController) extends Observer:
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
            case "restart" => controller.doAndPublish(controller.createField); None
            case "save" => controller.save; None
            case "load" => controller.load; None
            case "undo" => controller.doAndPublish(controller.undo); None
            case "redo" => controller.doAndPublish(controller.redo); None
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
                )

                if(guess.length < 4) println("invalid input"); None
                Some(guess)
            }
    
    override def update = 
        print("\u001b[2J")
        controller.field.state match
            case State.Playing => println(controller.field.toString)
            case State.Won => println("You won the game !!!\ntype 'restart' to start a new game")
            case State.Lost => println("You lost the game :(\ntype 'restart' to start a new game")