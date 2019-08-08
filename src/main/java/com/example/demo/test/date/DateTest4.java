package com.example.demo.test.date;

import java.util.Date;
import java.util.Map;

import com.google.common.collect.Maps;

public class DateTest4 {

	public static void main(String[] args) {
		DeviceTime deviceTime = new DeviceTime();
		deviceTime.setStartTime(new Date());
		System.out.println(deviceTime);
		System.out.println("11111"+deviceTime.getEndTime());
		
		Map<String,DeviceTime> map=Maps.newHashMap();
		DeviceTime deviceTime2 = map.get("123");
		System.out.println(deviceTime2);
		
		DeviceTime deviceTime3 = new DeviceTime();
		deviceTime3.setStartTime(null);
		deviceTime3.setEndTime(null);
		System.out.println("22222"+deviceTime3);
		System.out.println("22222"+deviceTime3.getStartTime());
		System.out.println("22222"+deviceTime3.getEndTime());
	}
}

class DeviceTime{
	private Date startTime;
	private Date endTime;
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
}