package com.example.demo.bio.basic;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class BIOServer0 {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		
		/**
		 * 使用tcp协议接收数据
		 * 步骤:
		 * 1. 创建服务端Socket对象
		 * 2. 监听(阻塞)
		 * 3. 获取输入流对象
		 * 4. 获取数据
		 * 5. 输出数据
		 * 6. 释放资源
		 */
		
		//1. 创建服务端Socket对象
		ServerSocket serverSocket = new ServerSocket(8848);
		
		System.out.println("0监听前....");
		//2. 监听(阻塞)
		Socket socket = serverSocket.accept();
		System.out.println("1监听后....");
		
		//3. 获取输入流对象,创建容器
		InputStream is = socket.getInputStream();
		System.out.println("2获取输入流对象....");
		
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		byte[] bys = new byte[1024];
		int len;
		while ((len = is.read(bys))!=-1) {
			bos.write(bys, 0, len);
		}
		
		byte[] data = bos.toByteArray();
		InetAddress address = socket.getInetAddress();
		System.out.println(address.getHostName());
		System.out.println(new String(data));
		
		socket.close();
	}
	
}
