package com.example.demo.bio.demo2;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import io.netty.util.internal.StringUtil;


public class BIOServer {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		
		ServerSocket serverSocket = new ServerSocket(8868);
		Socket socket = serverSocket.accept();
		InputStream is = socket.getInputStream();
		byte[] data = new byte[1024];
		int len;
		len = is.read(data);
		
		String info = new String(data,0,len);
		System.out.println("从客户端接收到的数据是"+info);
		//System.out.println(info);
		String result;
		if(StringUtil.isNullOrEmpty(info)) {
			result = "未接收到数据";
		}else {
			result = info.toUpperCase();
		}
		
		System.out.println("发送到客户端的数据是"+result);
		OutputStream os = socket.getOutputStream();
		os.write(result.getBytes());
		
		//socket.close();
	}
}
