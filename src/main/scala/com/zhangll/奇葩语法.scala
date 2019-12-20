package com.zhangll
import scala.collection.immutable

object 奇葩语法 {
  def sayhello(int : Int) ={
    println(int)
  }
  def sayTwoType(int : Int, int2: Int)={
    println(int, int2)
  }

  def main(args: Array[String]): Unit = {
    // 文法层面是一致的
    sayhello{123245}
    sayhello(12345)
    // 模式匹配语句不是函数scala 中只有一个参数的函数 在调用时候可以忽略括号，直接传一个对象
    // 两个的话就不能这么搞了 ，在spark中也有很多应用
    sayTwoType (1,211)

    val list: immutable.Seq[Int] = List(1,2,3,4)

    val new2 = list.map {
      case 2 => "22"
    }
    val new1 = list.map{
      a => 1
    }

//    println(new2)
    println(new1)
  }
}
