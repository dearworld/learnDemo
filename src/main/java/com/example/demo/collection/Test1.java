package com.example.demo.collection;

import java.util.ArrayList;
import java.util.List;

public class Test1 {
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("JavaScript");
		list.add("python");
		list.add("go");
		System.out.println(list);
		list.add(0, "java");
		System.out.println(list);
		list.add("C#");
		System.out.println(list);
	}
}
