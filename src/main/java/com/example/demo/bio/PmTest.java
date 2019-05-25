package com.example.demo.bio;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class PmTest {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		Socket socket = new Socket("123.15.58.210", 9123);
		String message = "test\n";
		OutputStream os = socket.getOutputStream();
		os.write(message.getBytes());
		
		InputStream is = socket.getInputStream();
		byte[] bys = new byte[1024];
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		int len;
		while ((len = is.read(bys))!=-1) {
			bos.write(bys, 0, len);
		}
		byte[] data = bos.toByteArray();
		System.out.println(new String(data));
		bos.close();
		is.close();
		os.close();
		bos.close();
	}
}

