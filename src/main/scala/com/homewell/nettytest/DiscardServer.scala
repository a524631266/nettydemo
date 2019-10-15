package com.homewell.nettytest

import io.netty.bootstrap.ServerBootstrap
import io.netty.channel.{ChannelFuture, ChannelInitializer, ChannelOption}
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.SocketChannel
import io.netty.channel.socket.nio.NioServerSocketChannel
import io.netty.util.concurrent.{Future, GenericFutureListener}

/**
  * https://www.cnblogs.com/imstudy/p/9908791.html
  * NIO 主要实现主从reactor结构
  */
class DiscardServer {
  private var port: Int = _
  def this(port: Int) {
    this()
    this.port = port
  }

  def run(): Unit = {
    val server = new ServerBootstrap()
    // 两个reactor
    val boss = new NioEventLoopGroup() // main 每个端口bind一个boss线程
    val work = new NioEventLoopGroup // slave 被各个线程充分使用

    try {
      server.group(boss, work)
        .channel((new NioServerSocketChannel).getClass) // 注册一个类，用来在未来一旦过来一个连接创建打开通道（事件队列中事件通过分发器分发的通道）  instantiate a new Channel to accept incoming connections.
        .childHandler(new ChannelInitializer[SocketChannel] {
        override def initChannel(ch: SocketChannel): Unit = {
          ch.pipeline()
            .addLast(new DiscardServerHandler)
//            .addLast("")
        }
      }) // 以一个channel管道方式进行事件触发
        .option[Integer](ChannelOption.SO_BACKLOG, 128) // 父reactor的连接配置
        .childOption[java.lang.Boolean](ChannelOption.SO_KEEPALIVE, true) // 给子reactor的配置


      val bind_future: ChannelFuture = server.bind(port) //
      bind_future.sync()
      bind_future.addListener(new GenericFutureListener[Future[_ >: Void]] {
        override def operationComplete(future: Future[_ >: Void]): Unit = {
          if(future.isSuccess){
            println("绑定成功")
          }else{
            println("绑定失败")
          }
        }
      })
    }finally {
//      boss.shutdownGracefully()
      ////      work.shutdownGracefully()
    }
  }

}
object DiscardServer{
  def main (args: Array[String] ): Unit = {
    val port = 8080
    val server = new DiscardServer(port)
    server.run()
  }
}