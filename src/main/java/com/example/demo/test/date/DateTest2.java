package com.example.demo.test.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest2 {
	public static void main(String[] args) {
		long time = 1000*60*30;
		long msPerHour = 1000*60*60;
		long msPerMinute = 1000*60;
		long msPerSecond = 1000;
		
		long hour = time/msPerHour;
		long minute = time%msPerHour/msPerMinute;
		long second = time%msPerHour%msPerMinute/msPerSecond;
		
		System.out.println(hour+"h:"+minute+"m:"+second+"s");
	}
}
