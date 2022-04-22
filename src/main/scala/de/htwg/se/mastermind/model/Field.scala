package de.htwg.se.mastermind.model

case class Field(rows: List[Row] = List()):
    val eol = sys.props("line.separator")

    def makeGuess(combination: List[Color]) = copy(rows:+Row(combination, Feedback(0,0)))
    override def toString: String = rows.map(_.toString + eol).mkString