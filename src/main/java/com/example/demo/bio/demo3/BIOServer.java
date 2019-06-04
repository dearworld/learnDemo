package com.example.demo.bio.demo3;

import static org.hamcrest.CoreMatchers.containsString;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class BIOServer {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		ServerSocket serverSocket = new ServerSocket(8888);
		while (true) {
			System.out.println("0 Server accept阻塞");
			Socket socket = serverSocket.accept();//阻塞
			System.out.println("1 Server getInputStream阻塞");
			InputStream is = socket.getInputStream();//阻塞
			byte[] bys = new byte[1024];
			is.read(bys);
			
			String host = socket.getInetAddress().getHostAddress();
			System.out.println(host+"说"+new String(bys).trim());
			
			OutputStream os = socket.getOutputStream();
			String msg = "没钱";
			os.write(msg.getBytes());
			socket.close();
		}
	}
}
