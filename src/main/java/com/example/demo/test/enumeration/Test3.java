package com.example.demo.test.enumeration;

import java.util.EnumMap;
import java.util.EnumSet;

public class Test3 {
	public static void main(String[] args) {
		EnumSet<EnumTest> enumSet = EnumSet.allOf(EnumTest.class);
		for (EnumTest enumTest : enumSet) {
			System.out.println(enumTest);
		}
		
		
		EnumMap<EnumTest, String> enumMap = new EnumMap<>(EnumTest.class);
		enumMap.put(EnumTest.MON, "星期一");
		enumMap.put(EnumTest.TUE, "星期二");
		System.out.println(enumMap);
	}
}
