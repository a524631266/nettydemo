package com.zhangll.futures

object SynchronizedTest {

  def main(args: Array[String]): Unit = {
    var count = 0
    synchronized{
      count = count + 1
    }


  }
}
