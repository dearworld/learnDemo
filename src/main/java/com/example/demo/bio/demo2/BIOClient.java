package com.example.demo.bio.demo2;


import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class BIOClient {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		Socket socket = new Socket("127.0.0.1", 8868);
		String msg = "你好,Server";
		System.out.println("client发送的数据为"+msg);
		OutputStream os = socket.getOutputStream();
		os.write(msg.getBytes());
		
		InputStream is = socket.getInputStream();
		byte[] data = new byte[1024];
		int len;
		len = is.read(data);
		System.out.println("服务端发来的数据是"+new String(data, 0, len));
		
		socket.close();
	}
}
