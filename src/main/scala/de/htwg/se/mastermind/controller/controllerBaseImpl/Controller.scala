package de.htwg.se.mastermind
package controller
package controllerBaseImpl


import com.google.inject.{Inject, Guice}
import net.codingwell.scalaguice.InjectorExtensions.ScalaInjector

import model.field.IField
import model.field.fieldBaseImpl.{Field, Row, Feedback, Color}
import model.fileio.IFileIO
import util.Observable
import util.UndoManager
import util.Command

case class Controller @Inject() (var field: IField) extends IController:
    val undoManager = new UndoManager[IField]

    def doAndPublish(func: List[Color] => IField, guess: List[Color]): Unit =
        field = func(guess)
        notifyObservers

    def doAndPublish(func: => IField): Unit =
        field = func
        notifyObservers
    
    def createField(): IField = Field()

    def makeGuess(guess: List[Color]): IField =
        undoManager.doStep(field, MakeGuessCommand(guess))

    def undo: IField = undoManager.undoStep(field)
    def redo: IField = undoManager.redoStep(field)

    def load: Unit = {
        val injector = Guice.createInjector(new MastermindModule)
        val fileio: IFileIO = injector.getInstance(classOf[IFileIO])
        field = fileio.load
        notifyObservers
    }
    def save: Unit = {
        val injector = Guice.createInjector(new MastermindModule)
        val fileio: IFileIO = injector.getInstance(classOf[IFileIO])
        fileio.save(field)
    }

    override def toString: String = field.toString