package com.example.demo.bio.demo1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * BIO网络编程服务器端
 * @author 015
 *
 */
public class BIOServer {
	
	public static void main(String[] args) throws Exception{
		ServerSocket socket = new ServerSocket(8888);
		Socket s = socket.accept();
		System.out.println("server11111");
/*			InputStream is = s.getInputStream();
			byte[] bys = new byte[is.available()];
			is.read(bys);*/
		BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
		String name = reader.readLine();
		System.out.println(name);
		System.out.println("server22222");
/*			OutputStream os = s.getOutputStream();
			String hostName = s.getInetAddress().getHostName();
			os.write((hostName+"你好，我已收到你发送的信息").getBytes());*/
		PrintWriter pw = new PrintWriter(s.getOutputStream());
		pw.println(s.getInetAddress().getHostAddress()+"你好，我已收到你发送的信息");
		s.close();
			
	}
}
