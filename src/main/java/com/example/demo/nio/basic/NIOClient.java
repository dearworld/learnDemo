package com.example.demo.nio.basic;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class NIOClient {
	public static void main(String[] args) throws Exception {
		//1. 得到一个网络通道
		SocketChannel socketChannel = SocketChannel.open();
		//2. 设置非阻塞方式
		socketChannel.configureBlocking(false);
		//3. 提供服务器端的 IP 地址和端口号
		InetSocketAddress address = new InetSocketAddress("localhost", 8888);
		//4. 连接服务器端
		if(!socketChannel.connect(address)) {
			while (!socketChannel.finishConnect()) {
				System.out.println("Client:连接服务器的同时,我还可以干点别的事情");
			}
		}
		//5. 得到一个缓冲区并存入数据
		String msg = "Hello Server";
		ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());
		socketChannel.write(buffer);
		System.in.read();
		
	}
}
