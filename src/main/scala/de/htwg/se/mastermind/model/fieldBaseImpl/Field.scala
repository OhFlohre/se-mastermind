package de.htwg.se.mastermind
package model
package fieldBaseImpl

import util.Random

case class Field(rows: List[Row] = List(), solution: List[Color]) extends FieldInterface:
    val eol = sys.props("line.separator")

    def append(row: Row) = copy(rows:+Row(guess, Feedback(guess, solution)))
    def remove() = copy(rows.dropRight(1))
    override def toString: String = rows.mkString(eol)

object Field {
    def apply(): Field = Field(solution: generateSolution())
        
    def generateSolution: List[Color] = List.fill(4)(Random.nextInt())

}