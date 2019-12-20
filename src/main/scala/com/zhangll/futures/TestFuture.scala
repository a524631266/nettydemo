package com.zhangll.futures

import java.util.concurrent.TimeUnit

import scala.collection.immutable.Range
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}
object TestFuture {
  def main(args: Array[String]): Unit = {
    // Future 传一个方法进去，只有一个参数，所以可以用 1 / 0 ，这个是scala特有的文法
    val f: Future[Int] = Future {
      1 / 0
    }

    // future使用方式一
    f onSuccess {
      case int => println(int)
    }
    f onFailure{
      case e1: ArithmeticException => println(" haha:" + e1.getMessage)
      case e => println("eeerrrr")
    }

    // future使用方式二
    val f2 = Future {
      1/ 0
    }

    f2 onComplete{
      case Success(int) => println("f2 success: " + int)
      case Failure(exception) => exception.printStackTrace()
    }
//    try{
////      Thread.sleep(TimeUnit.SECONDS(10))
//      Thread.sleep(10000)
//    }catch {
//      case e: Throwable => e.printStackTrace()
//    }

    var gv = 0;
    val fut = Future {
        for ( i <- 1 to 100) {
          gv +=1
          println(Thread.currentThread().getName + "::::" + gv)
        }
        println("sleep 1 s")
        Thread.sleep(1000)
      ; gv}
//    内部逻辑只执行一次，第二次调用会直接取结果
    fut onComplete{
      case Success(int) => println("fut success: " + int)
      case Failure(exception) => exception.printStackTrace()
    }

    fut onComplete{
      case Success(int) => println("fut22222 success: " + int)
      case Failure(exception) => exception.printStackTrace()
    }

    TimeUtils.sleeps(10)
  }
}
