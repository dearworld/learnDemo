package com.example.demo.netty.helloworld;

import com.example.demo.netty.basic.NettyClientHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

public class HelloWorldClient {

    public static void main(String[] args) throws InterruptedException {
        //1. 创建线程组
        NioEventLoopGroup loopGroup = new NioEventLoopGroup();
        //2. 创建客户端启动助手并配置参数
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(loopGroup)   //3. 设置客户端线程组
                .channel(NioSocketChannel.class)   //4. 设置客户端通道
                .handler(new ChannelInitializer<SocketChannel>() { //5. 创建一个通道初始化对象
                    @Override    //6. 向Pipeline链中添加自定义业务handler
                    protected void initChannel(SocketChannel channel) throws Exception {
                        channel.pipeline().addLast("decoder", new StringDecoder());
                        channel.pipeline().addLast("encoder", new StringEncoder());
                        channel.pipeline().addLast(new HelloWorldClientHandler()); //客户端业务处理类
                        System.out.println("......Client is ready......");
                    }
                });
        //7. 启动客户端，等待连接上服务器（非阻塞）
        ChannelFuture future = bootstrap.connect("127.0.0.1",8889).sync();
        future.channel().writeAndFlush("Hello Netty Server ,I am a common client");
        //8. 等待关闭连接（非阻塞）
        future.channel().closeFuture().sync();
    }
}
