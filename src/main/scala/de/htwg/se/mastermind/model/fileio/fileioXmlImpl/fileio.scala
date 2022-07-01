package de.htwg.se.mastermind
package model
package fileio
package fileioXmlImpl


import scala.xml.{ NodeSeq, PrettyPrinter, XML }
import com.google.inject.{Inject, Guice}
import java.io.PrintWriter

import field.IField
import field.fieldBaseImpl.{Field, Row,Color, Feedback, State}


class FileIO @Inject() extends IFileIO:
    override def load: IField = {
        val injector = Guice.createInjector(new MastermindModule)
        val file = XML.loadFile("field.xml")
        val solution = (file \\ "solution" \\ "color").map(color => Color.fromOrdinal(color.text.toInt)).toList
        val size = (file \\ "@size").text.toInt
        val state = (file \\ "@state").text.toInt
        val rows = (file \\ "row").map(row => 
            val colors = (row \\ "color").map(color => Color.fromOrdinal(color.text.toInt)).toList
            val correctPositions = (row \\ "@correctPositions").text.toInt
            val correctColors = (row \\ "@correctColors").text.toInt
            Row(colors, Feedback(correctPositions, correctColors))
        ).toList

        Field(rows, solution, size, State.fromOrdinal(state))
    }

    override def save(field: IField): Unit = {
        val prettyPrinter = new PrettyPrinter(80,4)
        val writer = new PrintWriter("field.xml")
        val xmlString = prettyPrinter.format(fieldToXML(field))
        writer.write(xmlString)
        writer.close
    }

    def fieldToXML(field: IField) = {
        <field size={field.size.toString} state={field.state.ordinal.toString}>
            <solution>
                {field.solution.map(color => <color>{color.ordinal}</color>)}
            </solution>
            {field.rows.map(row => 
                <row correctPositions={row.feedback.correctPositions.toString} correctColors={row.feedback.correctColors.toString}>
                    {row.guess.map(color =>
                        <color>{color.ordinal}</color>
                    )}
                </row>
            )}
        </field>
    }
