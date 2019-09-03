package com.example.demo.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import com.google.common.collect.Sets;

public class Test5 {
	
	@Test
	public void test1() {
		Set<String> set = Sets.newConcurrentHashSet();
		set.add("Java");
		System.out.println(set);
		System.out.println(set.size());
		set.clear();
		System.out.println(set);
		System.out.println(set.size());
	}
}
