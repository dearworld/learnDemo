package com.example.demo.test.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest6 {
	
	public static long reduce(Date time1,Date time2) {
		return time1.getTime()-time2.getTime();
	}
	
	public static void main(String[] args) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
	}
}	
