package de.htwg.se.mastermind
package model
package fieldBaseImpl


import com.google.inject.Inject


case class Field(rows: List[Row] = List()) extends FieldInterface:
    val eol = sys.props("line.separator")

    def append(row: Row) = copy(rows:+row)
    def removeLast() = copy(rows.dropRight(1))
    override def toString: String = rows.mkString(eol)

object Field {
    val random = scala.util.Random   
    def generateSolution: List[Color] = List.fill(4)(random.nextInt(6)).map(number => Color.fromOrdinal(number))

}