package com.example.demo.netty.basic;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class NettyServer {
	
	public static void main(String[] args) throws Exception{
		//1. 创建一个线程组，用来处理网络连接事件，即接收客户端连接
		NioEventLoopGroup bossGroup = new NioEventLoopGroup();
		
		//2. 创建一个线程组，用来处理通道IO操作
		NioEventLoopGroup workerGroup = new NioEventLoopGroup();
		
		//3. 创建服务器端启动助手配置参数
		ServerBootstrap bootstrap = new ServerBootstrap();
		bootstrap.group(bossGroup, workerGroup) //4. 设置两个线程组
				.channel(NioServerSocketChannel.class) //5. 设置服务器通道
				.option(ChannelOption.SO_BACKLOG, 128) // 6. 设置线程队列中等待连接的个数
				.childOption(ChannelOption.SO_KEEPALIVE, true)   //7. 保持活动连接状态
				.childHandler(new ChannelInitializer<SocketChannel>() { //8. 创建一个通道初始化对象
					@Override    //9. 向Pipeline链中添加自定义业务handler
					protected void initChannel(SocketChannel channel) throws Exception {
						channel.pipeline().addLast(new NettyServerHandler()); //服务端处理类
						System.out.println("......Server is ready......");
					}
				});
		
		System.out.println("Server 111111");
		//10. 启动服务器端并绑定端口，等待接受客户端连接（非阻塞）
		ChannelFuture future = bootstrap.bind(8081).sync();
		System.out.println("......Server is starting......");
		
		//11. 关闭通道，关闭线程池
		future.channel().closeFuture().sync();
		bossGroup.shutdownGracefully();
		workerGroup.shutdownGracefully();
	}
}
