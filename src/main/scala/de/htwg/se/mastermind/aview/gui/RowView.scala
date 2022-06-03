package de.htwg.se.mastermind
package aview


import scalafx.scene.layout._
import scalafx.geometry._
import scalafx.scene.shape._
import scalafx.scene.paint.Color._


import model.fieldBaseImpl.Color
import model.RowInterface


class RowView(row: RowInterface) extends HBox {

    this.children = Seq(
        new FeedbackView(row.feedback),
        new HBox {
            children = row.guess.data.map(color => {
                new Circle{
                    radius=30
                    fill=color match
                        case Color.Red => Red
                        case Color.Blue => Blue
                        case Color.Green => Green
                        case Color.Cyan => Cyan
                        case Color.Magenta => Magenta
                        case Color.Yellow => Yellow
                        case Color.White => White
                }
            })
        }
    )

}