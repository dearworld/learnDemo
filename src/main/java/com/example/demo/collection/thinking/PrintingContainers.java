package com.example.demo.collection.thinking;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class PrintingContainers {
	
	static Collection fill(Collection<String> collection) {
		collection.add("Java");
		collection.add("Python");
		collection.add("Go");
		collection.add("C");
		return collection;
	}
	
	static Map fill(Map<Integer,String> map) {
		map.put(0, "Java");
		map.put(1, "Python");
		map.put(2, "Go");
		map.put(3, "C");
		return map;
	}
	
	
	public static void main(String[] args) {
		System.out.println(fill(new ArrayList<String>()));
		System.out.println(fill(new LinkedList<String>()));
		System.out.println(fill(new HashSet<String>()));
		System.out.println(fill(new TreeSet<String>()));
		System.out.println(fill(new LinkedHashSet<String>()));
		
		System.out.println(fill(new HashMap<Integer,String>()));
		System.out.println(fill(new LinkedHashMap<Integer,String>()));
		System.out.println(fill(new TreeMap<Integer,String>()));
	}
}
