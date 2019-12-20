package com.zhangll.futures

import java.util.concurrent.TimeUnit

object TimeUtils {
  def sleeps(int: Int) {

    try{
      //      Thread.sleep(TimeUnit.SECONDS(10))

//      Thread.sleep(int.toSeconds,TimeUnit.SECONDS())
      TimeUnit.SECONDS.sleep(int)
    }catch {
      case e: Throwable => e.printStackTrace()
    }
  }
}
