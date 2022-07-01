package de.htwg.se.mastermind
package model
package field
package fieldBaseImpl


import com.google.inject.Inject


case class Field(rows: List[IRow], solution: List[Color], size: Int, state: State) extends IField:
    val eol = sys.props("line.separator")

    def setRows(rows: List[IRow]): IField = copy(rows=rows) 

    def append(row: IRow) = 
        if(row.feedback.correctPositions == 4) return copy(rows:+row, state=State.Won)
        if(rows.size+1 >= size) return copy(rows:+row, state=State.Lost)
        copy(rows:+row)
    def removeLast() = copy(rows.dropRight(1))
    override def toString: String =
        rows.mkString(eol)

object Field {
    def apply(rows: List[IRow] = List(), size: Int = 8, state: State = State.Playing): IField =
        Field(rows, generateSolution(), size, state)
        
    val random = scala.util.Random
    def generateSolution() = List.fill(4)(random.nextInt(Color.all.size)).map(number => Color.fromOrdinal(number))
}