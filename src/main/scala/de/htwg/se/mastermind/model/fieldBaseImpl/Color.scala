package de.htwg.se.mastermind
package model
package fieldBaseImpl

enum Color(val code: String, val name: String):
    override def toString: String = code + "#" + Console.WHITE

    case Red extends Color(Console.RED, "red")
    case Blue extends Color(Console.BLUE, "blue")
    case Green extends Color(Console.GREEN, "green")
    case Cyan extends Color(Console.CYAN, "cyan")
    case Magenta extends Color(Console.MAGENTA, "magenta")
    case Yellow extends Color(Console.YELLOW, "yellow")

object Color:
    def all = Color.values.toSet