package de.htwg.se.mastermind
package controller
package controllerBaseImpl

import model.field.IField
import model.field.fieldBaseImpl.{Color, Row, Feedback}
import util.Command
import util.UndoManager

class MakeGuessCommand(guess: List[Color]) extends Command[IField]:
  override def doStep(field: IField): IField = field.append(Row(guess, Feedback(field.solution, guess)))
  override def undoStep(field: IField): IField = field.removeLast()
  override def redoStep(field: IField): IField = field.append(Row(guess, Feedback(field.solution, guess)))