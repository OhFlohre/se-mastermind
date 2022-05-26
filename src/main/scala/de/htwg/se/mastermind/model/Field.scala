package de.htwg.se.mastermind.model

case class Field(rows: List[Row] = List()):
    val eol = sys.props("line.separator")

    def append(row: Row) = copy(rows:+row)
    def remove() = copy(rows.dropRight(1))
    override def toString: String = rows.mkString(eol)