package com.example.demo.netty.helloworld;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

public class HelloWorldServer {
	private int port;

	public HelloWorldServer(int port) {
		super();
		this.port = port;
	}
	
	public void start() throws Exception {
		NioEventLoopGroup bossGroup = new NioEventLoopGroup();
		NioEventLoopGroup workerGroup = new NioEventLoopGroup();
        ServerBootstrap serverBootstrap = new ServerBootstrap().group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<SocketChannel>() {

                    @Override
                    protected void initChannel(SocketChannel channel) throws Exception {
                        channel.pipeline().addLast("decoder", new StringDecoder());
                        channel.pipeline().addLast("encoder", new StringEncoder());
                        channel.pipeline().addLast(new HelloWorldServerHandler());
                    }

                    ;
                }).option(ChannelOption.SO_BACKLOG, 128)
                .childOption(ChannelOption.SO_KEEPALIVE,true);

        //绑定端口,开始接收进来的连接
        ChannelFuture future = serverBootstrap.bind(port).sync();
        System.out.println("Server start listen at "+port);
        future.channel().closeFuture().sync();
    }

    public static void main(String[] args) throws  Exception{
        new HelloWorldServer(8889).start();
    }
}
