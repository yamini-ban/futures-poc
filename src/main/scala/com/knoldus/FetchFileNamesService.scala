package com.knoldus

import java.io.File

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class FetchFileNamesService {

  def extractInnerFiles(dir: String, newDir: String): Unit = Future {
    val d = new File(newDir)
    if (d.exists && d.isDirectory) {
      val content = d.listFiles.toList
      for (component <- content) {
        if (component.isFile) {
          val result = component.getPath.split(dir + "/")
          println(result(result.length - 1))
        }
        else {
          extractInnerFiles(dir, component.getPath)
        }
      }
    }
  }
  def printName(): Unit =
  {
    println("Hi there, Yamini")
  }
}
