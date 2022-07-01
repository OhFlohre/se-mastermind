package de.htwg.se.mastermind
package model
package fileio

import field.IField

trait IFileIO {
    def load: IField
    def save(field: IField): Unit 
}