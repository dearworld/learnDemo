package com.example.demo.collection;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Maps;

public class Test3 {
	
	public static Map<String,List<String>> vedioLiveSocket = Maps.newConcurrentMap();
	
	public static void main(String[] args) {
		System.out.println(vedioLiveSocket.containsKey("123"));
	}
}
