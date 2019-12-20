package com.zhangll.futures

import java.util.concurrent.TimeUnit

import scala.concurrent.{Await, Future}
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global
import org.scalatest
object DurationTest {
  def main(args: Array[String]): Unit = {
    val fuc = Future {
      TimeUtils.sleeps(1)
      21 + 21
    }
    val result: Int = Await.result(fuc, 2.seconds)
    val d: FiniteDuration = 15.seconds

//    val dd = d.fromNow
//    println(dd)

    val timeoutSecond = 0
    val duration = Duration(timeoutSecond, TimeUnit.SECONDS)

//    val dd: Deadline = duration.fromNow
    println("start zero: " + Duration.Zero.toSeconds)

    println("start : " + duration.fromNow.time.toSeconds)
    println("start : " + duration.fromNow.isOverdue())
    TimeUtils.sleeps(1)
    println("4 secondes after : " + duration.fromNow.time.toSeconds)
    println("4 secondes after : " + duration.fromNow.isOverdue())
    import org.scalatest.Matchers._

    val fut = Future {
      Thread.sleep(1000)
      21 + 21
    }
    val x = Await.result(fut, 1.seconds)
    x should be (42)

    import org.scalatest.concurrent.ScalaFutures._
    fut.futureValue should be (42)

    println("###########################################")

    val future1 = Future{
      println("future1")
      20 + 12
    }
    val future2 = Future {
      TimeUtils.sleeps(1)
      println("future2")
      30 + 1
    }
    TimeUtils.sleeps(1)
//    val futrues = Future.sequence(List(fut,fuc))
////    TimeUtils.sleeps(2)
//    val ddd: Future[List[Int]] = futrues.map(a => a.toList)
//    println(ddd)
  }
}
