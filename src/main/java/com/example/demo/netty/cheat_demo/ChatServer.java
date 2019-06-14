package com.example.demo.netty.cheat_demo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

public class ChatServer {
    private int port;

    public ChatServer(int port) {
        this.port = port;
    }

    public void run()throws Exception{
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup,workGroup).channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();  //得到pipeline链
                            //向Pipeline链中添加一个解码器
                            pipeline.addLast("decoder",new StringDecoder());
                            //向Pipeline链中添加一个编码器
                            pipeline.addLast("encoder",new StringEncoder());
                            //往 Pipeline 链中添加一个自定义的业务处理对象
                            pipeline.addLast("handler", new ChatServerHandler());
                        }
                    }).option(ChannelOption.SO_BACKLOG,128)
                    .childOption(ChannelOption.SO_KEEPALIVE,true);

            System.out.println("Netty Chat Server 启动......");
            ChannelFuture future = b.bind(port).sync();
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
            System.out.println("Netty Chat Server 关闭......");
        }
    }

    public static void main(String[] args) throws Exception{
        new ChatServer(8889).run();
    }
}
