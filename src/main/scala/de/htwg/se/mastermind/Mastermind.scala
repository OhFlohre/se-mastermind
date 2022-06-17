package de.htwg.se.mastermind

import aview.TUI
// import aview.GUI
import controller.controllerBaseImpl.Controller
import model.fieldBaseImpl.Field

@main def main: Unit = 
    val field = new Field()
    val controller = Controller(field)
    //controller.add(GUI)
    val tui = TUI(controller)
    /*val gui = GUI(controller)
     val guiThread = new Thread {
        override def run: Unit = {
            gui.main(Array[String]())
        }
    }
    guiThread.start() */
    tui.run
