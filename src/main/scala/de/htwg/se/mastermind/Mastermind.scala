package de.htwg.se.mastermind


import com.google.inject.{Guice, Injector}
import net.codingwell.scalaguice.ScalaModule

import aview.TUI
import aview.GUI
import controller.IController
import model.field.IField
import model.field.fieldBaseImpl.Color


@main def main: Unit = 
    val injector = Guice.createInjector(new MastermindModule)
    val controller = injector.getInstance(classOf[IController])
    //controller.load

    val tui = TUI(controller)
    val gui = GUI(controller)
    val guiThread = new Thread {
        override def run: Unit = {
            gui.main(Array[String]())
        }
    }
    guiThread.start()
    tui.run
