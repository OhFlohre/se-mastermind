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
        getInputAndPrintLoop()

    override def update: Unit = ()

    def getInputAndPrintLoop(): Unit =
        val input = readLine
        input match
                case "q" => 
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
                    controller.makeGuess(combination)
                    println(controller.toString)
                    getInputAndPrintLoop()
            }