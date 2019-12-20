package com.zhangll.futures

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
object FutureMapTest {
  def main(args: Array[String]): Unit = {
    val func = Future {
        val x = 0
        println(Thread.currentThread().getName + " of x is " + x)
        x
    }
    val newf: Future[Int] = func.map(x => {println(Thread.currentThread().getName + " of x1 is " + x);x+1})

//    newf onComplete ()
    println(Thread.currentThread().getName + " main " )
    TimeUtils.sleeps(10)
  }
}
