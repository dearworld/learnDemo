package com.example.demo.collection;

import java.util.Map;

import com.google.common.collect.Maps;

public class Test2 {
	
	public static void main(String[] args) {
		Map<String,String> map = Maps.newHashMap();
		map.put("1", "java");
		map.put("2", "python");
		map.put("3", "php");
		System.out.println(map);
		
		for (String key : map.keySet()) {
			System.out.println(key+":"+map.get(key));
		}
		
		if(map.containsKey("3")) {
			map.put("3", "go");
		}
		System.out.println(map);
	}
}
