package com.example.demo.bio.demo1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * BIO网络编程客户端
 * @author 015
 *
 */
public class BIOClient {
	
	public static void main(String[] args) throws Exception {
		Socket socket = new Socket("127.0.0.1", 8888);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("请输入传输给服务端的信息:");
		String name = br.readLine();
		System.out.println(name);
		
		System.out.println("client1111");
		PrintWriter pw = new PrintWriter(socket.getOutputStream());
		System.out.println("client2222");
		pw.println(name);
		
		BufferedReader br2 = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String result = br2.readLine();
		System.out.println(result);
		socket.close();
	}
}
