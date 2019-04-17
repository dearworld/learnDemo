package com.example.demo.test.iptest;

import java.net.InetAddress;

public class InetAddressDemo {
	
	public static void main(String[] args) throws Exception {
		InetAddress inetAddress = InetAddress.getByName("DESKTOP-RBQRFKC");
		//InetAddress inetAddress = InetAddress.getLocalHost();
		String hostAddress = inetAddress.getHostAddress();
		String hostName = inetAddress.getHostName();
		System.out.println("hostAddress:"+hostAddress);
		System.out.println("hostName:"+hostName);
	}
}
