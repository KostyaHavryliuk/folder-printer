package com.khavryliuk.actors

import java.io.File

import akka.actor.Actor
import com.khavryliuk.models.PrintTree


class FilesActor extends Actor {
  def receive = {
    case PrintTree(path: String) => printContent(path)
    case wrongMsg => context.system.log.warning("receive unexpected message: " + wrongMsg)
  }

  def printContent(path:String) = {
    val file = new File(path)
    if (!file.isDirectory) println("folder is not a Directory")
    else println(printDirectoryTree(file))

  }

  def printDirectoryTree(folder: File): String = {
    val indent = 0
    val sb = new StringBuilder
    printDirectoryTree(folder, indent, sb)
    sb.toString
  }

  private def printDirectoryTree(folder: File, indent: Int, sb: StringBuilder): Unit = {
    sb.append(getIndentString(indent, isFile = false))
      .append("└ ")
      .append(folder.getName)
      .append("/")
      .append("\n")
    for (file <- folder.listFiles) {
      if (file.isDirectory) printDirectoryTree(file, indent + 1, sb)
      else printFile(file, indent + 1, sb)
    }
  }

  private def printFile(file: File, indent: Int, sb: StringBuilder): Unit = {
    sb.append(getIndentString(indent, isFile = true))
      .append("└ ")
      .append(file.getName)
      .append("\n")
  }

  private def getIndentString(indent: Int, isFile: Boolean) = {
    val sb = new StringBuilder
    var i = 0
    if (isFile){
      sb.append("|  ")
      while (i < indent) {
        sb.append("   ")
        i += 1; i - 1
      }
    } else {
      while (i < indent) {
        sb.append("|  ")
        i += 1; i - 1
      }
    }

    sb.toString
  }
}
