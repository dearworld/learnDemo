package com.example.demo.test.enumeration;

public class Test2 {
	public static void main(String[] args) {
		EnumTest tue = EnumTest.TUE;
		
		System.out.println(tue.compareTo(EnumTest.TUE));
		System.out.println(tue.getDeclaringClass().getName());
		System.out.println(tue.name());
		System.out.println(tue.toString());
		System.out.println(EnumTest.MON.ordinal());
		System.out.println(EnumTest.MON.getValue());
	}
}
