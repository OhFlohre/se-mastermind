package de.htwg.se.mastermind
package model
package fileio
package fileioJsonImpl


import play.api.libs.json._
import com.google.inject.{Inject, Guice}
import scala.io.Source
import java.io.PrintWriter

import field.IField
import field.fieldBaseImpl.{Field, Row, Color, Feedback, State}


class FileIO @Inject() extends IFileIO:
    override def load: IField = {
        val file: String = Source.fromFile("field.json").getLines.mkString
        val json = Json.parse(file)
        val solution = (json \ "field" \ "solution").get.as[List[Int]].map(Color.fromOrdinal(_))
        val size = (json \ "field" \ "size").as[Int]
        val state = (json \ "field" \ "state").as[Int]
        val rows = (json \ "field" \ "rows").get.as[List[JsValue]].map(row =>
            val guess = (row \ "guess").get.as[List[Int]].map(Color.fromOrdinal(_))
            val correctPositions = (row \ "correctPositions").as[Int]
            val correctColors = (row \ "correctColors").as[Int]
            Row(guess, Feedback(correctPositions, correctColors))
        )
        Field(rows, solution, size, State.fromOrdinal(state))
    }

    override def save(field: IField): Unit = {
        val writer = new PrintWriter("field.json")
        val jsonString = Json.prettyPrint(fieldToJSON(field))
        writer.write(jsonString)
        writer.close
    }

    def fieldToJSON(field: IField) = {
        Json.obj(
            "field" -> Json.obj(
                "state" -> JsNumber(field.state.ordinal),
                "size" -> JsNumber(field.size),
                "solution" -> JsArray(field.solution.map(color => JsNumber(color.ordinal))),
                "rows" -> JsArray(field.rows.map(row =>
                    Json.obj(
                        "guess" -> JsArray(row.guess.map(color => JsNumber(color.ordinal))),
                        "correctPositions" -> JsNumber(row.feedback.correctPositions),
                        "correctColors" -> JsNumber(row.feedback.correctColors)
                    )
                ))
            ) 
        )
    }
