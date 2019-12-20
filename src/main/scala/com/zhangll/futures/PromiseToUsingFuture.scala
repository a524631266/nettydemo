package com.zhangll.futures

import scala.concurrent.Promise
object PromiseToUsingFuture {
  def main(args: Array[String]): Unit = {
    val pro = Promise[Int]
      println(Thread.currentThread().getName)
      TimeUtils.sleeps(2)
      30 + 30

    val fut = pro.future
    // 堵塞住，只有future完成之后才会调用
    pro.success{
      // main
      println(Thread.currentThread().getName)
      TimeUtils.sleeps(2)
      21 + 21
    }
    println(fut.value)
    println(12324)
//    println(fut.value)
  }
}
