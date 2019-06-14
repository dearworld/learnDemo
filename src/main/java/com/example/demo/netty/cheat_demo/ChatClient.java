package com.example.demo.netty.cheat_demo;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoop;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.util.Scanner;

public class ChatClient {
    private final String host;  //服务器端ip地址
    private final int port;

    public ChatClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void run() throws Exception{
        NioEventLoopGroup group = new NioEventLoopGroup();

        try {
            Bootstrap bootstrap = new Bootstrap().group(group).channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();  //得到pipeline链
                            //向Pipeline链中添加一个解码器
                            pipeline.addLast("decoder", new StringDecoder());
                            //向Pipeline链中添加一个编码器
                            pipeline.addLast("encoder", new StringEncoder());
                            //往 Pipeline 链中添加一个自定义的业务处理对象
                            pipeline.addLast("handler", new ChatClientHandler());
                        }
                    });

            Channel channel = bootstrap.connect(host, port).sync().channel();
            System.out.println("--------"+channel.localAddress().toString().substring(1)+"--------");

            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()){
                String msg = scanner.nextLine();
                channel.writeAndFlush(msg+"\r\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception{
        new ChatClient("localhost",8888).run();
    }
}
