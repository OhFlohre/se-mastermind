package de.htwg.se.mastermind
package model
package field


import fieldBaseImpl.{Color}


trait IField {
    val rows: List[IRow]
    val solution: List[Color]
    def setRows(rows: List[IRow]): IField
    def append(row: IRow): IField
    def removeLast(): IField
    def toString(): String
}

trait IRow {
    val guess : List[Color]
    val feedback: IFeedback
}

trait IFeedback {
    val correctPositions: Int
    val correctColors: Int
}