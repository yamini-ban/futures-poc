package com.knoldus

object AppDriver extends App {
  val fetchFileNamesService = new FetchFileNamesService()
  fetchFileNamesService.extractInnerFiles("src", "src")
  Thread.sleep(5 * 1000)
}
