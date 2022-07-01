package de.htwg.se.mastermind


import com.google.inject.AbstractModule
import com.google.inject.TypeLiteral
import com.google.inject.name.Names
import com.google.inject.Binder
import net.codingwell.scalaguice.ScalaModule

import controller.IController
import controller.controllerBaseImpl.Controller
import model.field.fieldBaseImpl.{Field, Color}
import model.field.IField
import model.fileio.fileioJsonImpl
import model.fileio.fileioXmlImpl
import model.fileio.IFileIO


class MastermindModule extends AbstractModule {
  override def configure(): Unit =
    bind(classOf[IController]).toInstance(Controller(Field()))
    bind(classOf[IFileIO]).toInstance(fileioXmlImpl.FileIO())
}