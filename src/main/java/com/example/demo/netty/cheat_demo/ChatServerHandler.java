package com.example.demo.netty.cheat_demo;

import com.google.common.collect.Lists;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.List;

public class ChatServerHandler extends SimpleChannelInboundHandler<String> {

    public static List<Channel> channels = Lists.newArrayList();

    @Override   //通道就绪
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel incoming = ctx.channel();
        channels.add(incoming);
        System.out.println("[Server]:"+incoming.remoteAddress().toString().substring(1)+"在线");
    }

    @Override   //通道未就绪
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel incoming = ctx.channel();
        channels.remove(incoming);
        System.out.println("[Server]:"+incoming.remoteAddress().toString().substring(1)+"掉线");
    }

    @Override  //读取数据
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        Channel incoming = ctx.channel();
        for(Channel channel:channels){
            if(channel != incoming){
                channel.writeAndFlush("["+incoming.remoteAddress().toString().substring(1)+"]说:"
                +msg+"\n");
            }
        }
    }

    @Override  //发生异常
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
        Channel incoming = ctx.channel();
        System.out.println("[Server]:"+incoming.remoteAddress().toString().substring(1)+"异常");
    }
}
