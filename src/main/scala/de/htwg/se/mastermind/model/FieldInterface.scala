package de.htwg.se.mastermind
package model

import fieldBaseImpl.Color
import fieldBaseImpl.Combination

trait FieldInterface {
    val rows: List[RowInterface]
    def append(row: RowInterface): FieldInterface
    def remove(): FieldInterface
    def toString(): String
}

trait RowInterface {
    val feedback: FeedbackInterface
    val guess: CombinationInterface
    def toString(): String
}

trait FeedbackInterface {
    val correctPositions: Int
    val correctColors: Int
    def toString(): String
}

trait CombinationInterface {
    val data: List[Color]
}