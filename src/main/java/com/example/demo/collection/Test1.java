package com.example.demo.collection;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class Test1 {
	
	public static void main(String[] args) {
		
		Map<String, List<String>> map = Maps.newHashMap();
		List<String> list = Lists.newArrayList();
		list.add("system");
		map.put("10010", list);
		
		map.put("10000", null);
		LiveOnCache.setMap(map);
		System.out.println(LiveOnCache.getMap());
		
		LiveOnCache.addUser("10010", "user");
		System.out.println(LiveOnCache.getMap());
		
		LiveOnCache.addUser("10086", "root");
		System.out.println(LiveOnCache.getMap());
		
		LiveOnCache.addUser("10010", "user");
		System.out.println(LiveOnCache.getMap());
		
		LiveOnCache.addUser("10000", "test");
		System.out.println(LiveOnCache.getMap());
		
		LiveOnCache.delUserNo("10000", "test");
		System.out.println(LiveOnCache.getMap());
		
		LiveOnCache.addUser("10000", "test2");
		System.out.println(LiveOnCache.getMap());
	}
}
