package de.htwg.se.mastermind
package model


import fieldBaseImpl.{Color, Row}


trait FieldInterface {
    val rows: List[Row]
    def append(row: Row): FieldInterface
    def removeLast(): FieldInterface
    def toString(): String
}