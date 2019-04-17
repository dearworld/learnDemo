package com.example.demo.test.data;

import java.text.DecimalFormat;

public class DoubleTest {
	public static void main(String[] args) {
		System.out.println(DoubleTest.oneAfter(97.800003));
	}
	
	
	public static double oneAfter(double num) {
		DecimalFormat format = new DecimalFormat("#.0");
		String doubleNum = format.format(num);
		return Double.valueOf(doubleNum);
	}
}
