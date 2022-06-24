package de.htwg.se.mastermind


import com.google.inject.{Guice, Injector}
import net.codingwell.scalaguice.ScalaModule

import aview.TUI
import aview.GUI
import controller.ControllerInterface
import model.FieldInterface


@main def main: Unit = 
    //val field = Field()
    //val controller = Controller(field)
    val injector = Guice.createInjector(new MastermindModule)
    val field = injector.getInstance(classOf[FieldInterface])
    val controller = injector.getInstance(classOf[ControllerInterface])

    val tui = TUI(controller)
    val gui = GUI(controller)
    val guiThread = new Thread {
        override def run: Unit = {
            gui.main(Array[String]())
        }
    }
    guiThread.start()
    tui.run
