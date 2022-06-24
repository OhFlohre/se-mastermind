package de.htwg.se.mastermind


import com.google.inject.AbstractModule

import controller.ControllerInterface
import controller.controllerBaseImpl.Controller
import model.FieldInterface
import model.fieldBaseImpl.Field

class MastermindModule extends AbstractModule {
  override def configure(): Unit =
    bind(classOf[FieldInterface]).to(classOf[Field])
    bind(classOf[ControllerInterface]).to(classOf[Controller])
}