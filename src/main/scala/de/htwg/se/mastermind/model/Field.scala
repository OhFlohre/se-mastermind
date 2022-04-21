package de.htwg.se.mastermind.model

case class Field(rows: List[Row]):
    def this(num_tries: Int = 8) = this(List.fill(num_tries)(new Row(4)))

    val eol = sys.props("line.separator")

    override def toString: String = rows.map(_.toString + eol).mkString