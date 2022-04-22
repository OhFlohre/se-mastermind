package de.htwg.se.mastermind.util


trait Observer {
    def update: Unit
}

class Observable {
    val subscribers: Vector[Observer] = Vector()
    def add(s:Observer) = subscribers=subscribers:+s
    def remove(s:Ovserver) = subscribers = subscribers.filterNot(o=>o==s)
    def notifyObservers = subscribers.foreach(s => s.update)
}