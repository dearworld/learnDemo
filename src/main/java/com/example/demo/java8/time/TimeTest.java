package com.example.demo.java8.time;


import java.time.LocalDate;

import org.junit.Test;

public class TimeTest {
	
	@Test
	public void test1() {
		LocalDate today = LocalDate.now();
		System.out.println(today);
		int year = today.getYear();
		int month = today.getMonthValue();
		int day = today.getDayOfMonth();
		System.out.println("年："+year+"\n月："+month+"\n日："+day);
		LocalDate date = LocalDate.of(2019, 4, 26);
		System.out.println(date);
		System.out.println(today.equals(date));
		
	}
}
