package de.htwg.se.mastermind
package model
package fieldBaseImpl

case class Field(rows: List[RowInterface] = List()) extends FieldInterface:
    val eol = sys.props("line.separator")

    def append(row: RowInterface) = copy(rows:+row)
    def remove() = copy(rows.dropRight(1))
    override def toString: String = rows.mkString(eol)