package com.knoldus

import java.io.File
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

class FetchFileNamesService {

  def extractInnerFiles(dir: String, newDir: String): Unit = Future{
    val d = new File(newDir)
    if (d.exists && d.isDirectory) {
      val content = d.listFiles.toList
      for (component <- content) {
        if (component.isFile) {
          println(component.getPath)
        }
        else {
          extractInnerFiles(dir, component.getPath)
        }
      }
    }
  }
}
