package com.example.demo.test.tcp;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		//创建服务器端socket
		//接收数据
		//解析展示数据
		//释放资源
		ServerSocket serverSocket = new ServerSocket(8085);
		System.out.println("111111111");
		Socket socket = serverSocket.accept();
		System.out.println("2222222222");
		InputStream is = socket.getInputStream();
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		byte[] bys = new byte[1024];
		int len;
		while((len = is.read(bys))!=-1) {
			bos.write(bys, 0, len);
		}
		byte[] data = bos.toByteArray();
		System.out.println(new String(data));
		bos.close();
		is.close();
		socket.close();
	}
}
