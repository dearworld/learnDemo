package com.example.demo.nio.basic;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class NIOServer {
	public static void main(String[] args) throws Exception {
		//1. 得到一个serverSocketChannel对象
		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		//2. 得到一个Selector对象
		Selector selector = Selector.open();
		//3. 绑定一个端口号
		serverSocketChannel.bind(new InetSocketAddress(8888));
		//4. 设置非阻塞方式
		serverSocketChannel.configureBlocking(false);
		//5. 把 ServerSocketChannel 对象注册给 Selector 对象
		serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
		//6.干活
		while (true) {
			//6.1 监控客户端
			if(selector.select(2000) == 0) {   //nio 非阻塞式的优势
				System.out.println("Server: 没有客户端连接,我先干点别的事情");
				continue;
			}
			
			//6.2 得到 SelectionKey,判断通道里的事件
			Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
			while (iterator.hasNext()) {
				SelectionKey key = iterator.next();
				if(key.isAcceptable()) {   //客户端连接请求事件
					System.out.println("OP_ACCEPT");
					SocketChannel socketChannel = serverSocketChannel.accept();
					socketChannel.configureBlocking(false);
					socketChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
				}
				
				if(key.isReadable()) {  //读取客户端数据事件
					SocketChannel channel = (SocketChannel) key.channel();
					ByteBuffer buffer = (ByteBuffer) key.attachment();
					channel.read(buffer);
					System.out.println("客户端发来数据:"+new String(buffer.array()));
				}
			}
			// 6.3 手动从集合中移除当前 key,防止重复处理
			iterator.remove();
		}
	}
}
