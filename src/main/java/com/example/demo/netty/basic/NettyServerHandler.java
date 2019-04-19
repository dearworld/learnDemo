package com.example.demo.netty.basic;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

public class NettyServerHandler extends ChannelInboundHandlerAdapter{
	
	@Override   //读取数据事件
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //ctx.fireChannelRead(msg);
		System.out.println("Server:"+ctx);
		ByteBuf buf = (ByteBuf) msg;
		System.out.println("客户端发来的消息:"+buf.toString(CharsetUtil.UTF_8));
    }
    
	@Override  //数据读取完毕事件
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        //ctx.fireChannelReadComplete();
		ctx.writeAndFlush(Unpooled.copiedBuffer("你好，客户端", CharsetUtil.UTF_8));
    }
    
	@Override  //异常发生事件
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
        //ctx.fireExceptionCaught(cause);
		cause.printStackTrace();
		ctx.close();
    }
}
