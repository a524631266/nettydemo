package com.homewell.nettytest



import io.netty.buffer.ByteBuf
import io.netty.channel.{ChannelHandlerContext, ChannelInboundHandler, ChannelInboundHandlerAdapter}
import io.netty.util.ReferenceCountUtil

/**
  * 句柄操作,处理服务端的channel
  * channel 就是一个通道（频道），没有频道就收不到信息，也无法传递信息
  * channel
  */
class DiscardServerHandler extends ChannelInboundHandlerAdapter{
  override def channelRead(ctx: ChannelHandlerContext, msg: Any): Unit = {
//    支持零拷贝的 ByteBuf 缓冲对象
    try {
      val msg_process  = msg.asInstanceOf[ByteBuf]
      println(1111)
//      while(msg_process.isReadable) {
        println("isReadable:",msg_process)

        Thread.sleep(1000)
//      }

//        代码二返回客户端
//        ctx.write(msg) // 输出服务 Netty releases it for you when it is written out to the wire，所以不需要写release
//        ctx.flush()
    }finally {
      //    强转类型
      msg.asInstanceOf[ByteBuf].release()
//      ReferenceCountUtil.release(msg)
    }
  }

  /**
    * 一旦出错就直直接关闭上下文
    * @param ctx
    * @param cause
    */
  override def exceptionCaught(ctx: ChannelHandlerContext, cause: Throwable): Unit = {
    cause.printStackTrace()
    ctx.close()
  }
}

//object DiscardProtocalDemo {
//  def main(args: Array[String]): Unit = {
//
//  }
//}
