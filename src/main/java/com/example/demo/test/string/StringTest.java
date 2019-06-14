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
		
		
		String name = "袁浩同学";
		int length = name.length();
		if(length>3) {
			name = name.substring(length-3,length);
		}
		System.out.println(name);
		
		String str = "864082010109430-2019-06-11-11_42_43.flv";
		String result = str.substring(0, str.indexOf("-"));
		System.out.println(result);
	}
	

}
