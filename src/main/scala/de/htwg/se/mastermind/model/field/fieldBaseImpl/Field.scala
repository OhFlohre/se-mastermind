package de.htwg.se.mastermind
package model
package field
package fieldBaseImpl


import com.google.inject.Inject


case class Field(rows: List[IRow], solution: List[Color]) extends IField:
    val eol = sys.props("line.separator")

    def setRows(rows: List[IRow]): IField =  copy(rows=rows) 

    def append(row: IRow) = copy(rows:+row)
    def removeLast() = copy(rows.dropRight(1))
    override def toString: String = rows.mkString(eol)

object Field {
    def apply(rows: List[IRow] = List()): IField =
        Field(rows, generateSolution())
        
    val random = scala.util.Random
    def generateSolution() = List.fill(4)(random.nextInt(Color.all.size)).map(number => Color.fromOrdinal(number))
}