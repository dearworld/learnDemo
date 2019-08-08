package com.example.demo.collection;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Test5 {
	
	@Test
	public void test1() {
		List<Object> list = new ArrayList<>();
		list.add(null);
		list.add("java");
		System.out.println(list);
	}
}
