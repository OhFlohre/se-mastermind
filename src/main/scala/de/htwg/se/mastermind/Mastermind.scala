package de.htwg.se.mastermind

import aview.TUI
import controller.Controller
import model.Field

@main def main: Unit = 
    val field = new Field()
    val controller = Controller(field)
    val tui = TUI(controller)
    tui.run