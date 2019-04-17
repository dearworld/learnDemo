package com.example.demo.test.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * 接收端
 * @author 015
 *
 */
public class ReceiveDemo {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		DatagramSocket socket = new DatagramSocket(8083);
		byte[] bys = new byte[1024];
		DatagramPacket p = new DatagramPacket(bys, bys.length);
		
		System.out.println("11111");
		socket.receive(p);
		System.out.println("22222");
		
		InetAddress address = p.getAddress();
		byte[] data = p.getData();
		int length = p.getLength();
		
		System.out.println(address.getHostName());
		System.out.println(new String(data, 0, length));
		socket.close();
	}
}
