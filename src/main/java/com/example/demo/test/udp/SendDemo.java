package com.example.demo.test.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 发送端
 * @author 015
 *
 */
public class SendDemo {
	public static void main(String[] args) throws Exception {
		DatagramSocket socket = new DatagramSocket();
		String str = "Hello udp,im coming!";
		byte[] bytes = str.getBytes();
		InetAddress localHost = InetAddress.getLocalHost();
		int port = 8083;
		DatagramPacket packet = new DatagramPacket(bytes,bytes.length,localHost,port);
		socket.send(packet);
		socket.close();
	}
}
