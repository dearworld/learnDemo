package com.example.demo.test.date;

import org.apache.commons.lang3.StringUtils;

public class DateTest5 {
	
	
	public static String secondToStr(long time) {
		long msPerHour = 1000*60*60;
		long msPerMinute = 1000*60;
		long msPerSecond = 1000;
		long hour = time/msPerHour;
		long minute = time%msPerHour/msPerMinute;
		long second = time%msPerHour%msPerMinute/msPerSecond;
		String hourStr = addZero(hour);
		String minuteStr = addZero(minute);
		String secondStr = addZero(second);
		StringBuilder builder = new StringBuilder();
		builder.append(hourStr).append(":").append(minuteStr).append(":").append(secondStr);
		return builder.toString();
	}
	
	public static String addZero(long data) {
		String dataStr = String.valueOf(data);
		if(StringUtils.isNotBlank(dataStr)&&dataStr.length()==1) {
			dataStr = dataStr.concat("0");
		}
		return dataStr;
	}
	
	public static void main(String[] args) {
		System.out.println(secondToStr(1));
	}
}
