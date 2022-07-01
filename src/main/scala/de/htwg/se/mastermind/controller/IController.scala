package de.htwg.se.mastermind
package controller


import util.Observable
import model.field.fieldBaseImpl.Color
import model.field.IField


trait IController extends Observable {
    var field : IField
    def createField() : IField
    def makeGuess(guess: List[Color]) : IField
    def undo: IField
    def redo: IField
    def toString: String

    def save: Unit
    def load: Unit

    def doAndPublish(func: List[Color] => IField, guess: List[Color]): Unit
    def doAndPublish(func: => IField): Unit
}