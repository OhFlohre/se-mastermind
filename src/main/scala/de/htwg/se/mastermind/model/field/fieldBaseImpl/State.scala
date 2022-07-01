package de.htwg.se.mastermind
package model
package field
package fieldBaseImpl

enum State(name: String):
    case Playing extends State("playing")
    case Won extends State("won")
    case Lost extends State("lost")