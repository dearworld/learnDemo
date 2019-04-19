package com.example.demo.netty.basic;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

public class NettyClientHandler extends ChannelInboundHandlerAdapter {

    @Override    //通道就绪事件
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        //ctx.fireChannelActive();
    	System.out.println("Client:"+ctx);
    	ctx.writeAndFlush(Unpooled.copiedBuffer("你好，服务器", CharsetUtil.UTF_8));
    }
    
    @Override    //通道读取数据事件
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //ctx.fireChannelRead(msg);
    	ByteBuf buf = (ByteBuf) msg;
    	System.out.println("服务器发来的消息："+buf.toString(CharsetUtil.UTF_8));
    }
    
    @Override   //数据读取完毕事件
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        //ctx.fireChannelReadComplete();
    	ctx.flush();
    }
    
    @Override   //异常发生事件
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
        //ctx.fireExceptionCaught(cause);
		cause.printStackTrace();
		ctx.close();
    }
}
