package de.htwg.se.mastermind
package aview


import scalafx.scene.layout._
import scalafx.geometry._
import scalafx.scene.shape._
import scalafx.scene.paint.Color._


import model.field.fieldBaseImpl.Color
import model.field.IRow


class RowView(row: IRow) extends HBox {

    this.children = Seq(
        new FeedbackView(row.feedback),
        new HBox {
            children = row.guess.map(color => {
                new Circle{
                    radius=30
                    fill=color match
                        case Color.Red => Red
                        case Color.Blue => Blue
                        case Color.Green => Green
                        case Color.Cyan => Cyan
                        case Color.Magenta => Magenta
                        case Color.Yellow => Yellow
                }
            })
        }
    )

}