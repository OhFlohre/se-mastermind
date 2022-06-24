package de.htwg.se.mastermind


import com.google.inject.AbstractModule
import com.google.inject.TypeLiteral
import com.google.inject.name.Names
import com.google.inject.Binder
import net.codingwell.scalaguice.ScalaModule

import controller.ControllerInterface
import controller.controllerBaseImpl.Controller
import model.FieldInterface
import model.fieldBaseImpl.Field


class MastermindModule extends AbstractModule {
  override def configure(): Unit =
    bind(classOf[ControllerInterface]).toInstance(new Controller(new Field()))
}