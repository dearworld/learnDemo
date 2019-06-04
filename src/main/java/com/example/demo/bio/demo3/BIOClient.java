package com.example.demo.bio.demo3;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class BIOClient {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {

		while (true) {
			Socket socket = new Socket("127.0.0.1", 8888);
			OutputStream os = socket.getOutputStream();
			System.out.println("请输入内容：");
			Scanner sc = new Scanner(System.in);
			String msg = sc.nextLine();
			os.write(msg.getBytes());
			
			System.out.println("0 Client getInputStream阻塞");
			InputStream is = socket.getInputStream();//阻塞
			byte[] data = new byte[1024];
			is.read(data);
			System.out.println("老板说:"+new String(data).trim());
			socket.close();
		}
	}
}
