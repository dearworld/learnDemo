package com.example.demo.test;

public class OddTest {
	
	public static void main(String[] args) {
		System.out.println(OddTest.isOdd(0));
	}
	
	
	public static boolean isOdd(int i) {
	    return (i & 1) == 1;
	}

}
