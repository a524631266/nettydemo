package com.homewell.nettytest

/**代表只有在nettytest以及器子孙包种的次啊能使用
  * 也就是在suntet中可以使用，在otherpakcage中无法使用
  * @param id
  */
private[nettytest] case class JVMObjectId(id: String) {
  // require是给客户端使用来那段客户端行为的，而assert是用来表示本身服务的问题
//  https://blog.csdn.net/u013007900/article/details/79179683
  require(id != null, "Object ID cannot be null.")
}
/**
  * test the topv
  */
object TopLevelPrivateTest {

  def main(args: Array[String]): Unit = {
    val objid = JVMObjectId("1")
    println(objid)
//none 用来表示一个空的对象，null是一个空指针
    val option1: Option[String] = None
    val dd = option1.getOrElse("11")
    println(dd)
  }
}
