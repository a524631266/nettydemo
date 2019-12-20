package com.zhangll.objectquesting

import com.zhangll.futures.TimeUtils

object OneHasObject{
  val thread = new Thread {
    () -> {
      while (true) {
        TimeUtils.sleeps(1)
        println(123)
      }
    }
  }

  lazy val start = {
    println(123)
    thread.setDaemon(true)
    thread.start()
  }
}
class OneHasObject {
  import OneHasObject._
//   只有调用的时候才初始化object内不的变量，一般object用来静态测试使用或者作为监控器使用
  start
}
