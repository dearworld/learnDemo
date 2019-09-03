package com.example.demo.test.string;

public class StringTest3 {
	public static void main(String[] args) {
		
		String str = "864082010105727_11_WEB_FF9CD911A0734D4880B745257180BD2C";
		String result = str.substring(str.indexOf("WEB"), str.length());
		System.out.println(result);
		
		String str2 = "0                           ";
		System.out.println(str2.substring(0,1));
	}
}
