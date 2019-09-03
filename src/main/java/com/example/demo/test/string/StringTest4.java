package com.example.demo.test.string;

public class StringTest4 {
	
	public static void main(String[] args) {
		String[] str = {"Java","Python","Go"};
		ergodic(str);
		
		String msg = "Hello,World";
		ergodic(msg);
		
		String msg2 = null;
		ergodic(msg2);
	}
	
	
	public static void ergodic(String...strings) {
		for (String str : strings) {
			System.out.println(str);
		}
	}
}	
