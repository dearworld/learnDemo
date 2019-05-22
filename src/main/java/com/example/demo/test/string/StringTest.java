package com.example.demo.test.string;

import java.util.UUID;

public class StringTest {
	public static void main(String[] args) {
/*		String coordinate = "x:113.696187 y:34.791319";
		int yIndex = coordinate.indexOf("y");
		System.out.println(yIndex);
		String x = coordinate.substring(2, yIndex-1);
		System.out.println(x);
		String y = coordinate.substring(yIndex+2, coordinate.length());
		System.out.println(y);*/
		
		
		System.out.println(UUID.randomUUID().toString().replace("-",""));
		String text = "你好,Java";
		System.out.println(text.toUpperCase());
	}
}
