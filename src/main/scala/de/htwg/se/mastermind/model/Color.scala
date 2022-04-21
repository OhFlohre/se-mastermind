package de.htwg.se.mastermind.model

enum Color(val code: String):
    override def toString: String = code + "#" + Color.White.code

    case Red extends Color(Console.RED)
    case Blue extends Color(Console.BLUE)
    case Green extends Color(Console.GREEN)
    case Cyan extends Color(Console.CYAN)
    case Magenta extends Color(Console.MAGENTA)
    case Yellow extends Color(Console.YELLOW)
    case White extends Color(Console.WHITE)

object Color:
    def all = Color.values.toSet