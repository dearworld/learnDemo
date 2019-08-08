package com.example.demo.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class Test6 {
	public static void main(String[] args) {
		
		Set<String> sets = Sets.newConcurrentHashSet();
		sets.add("java");
		sets.add("python");
		sets.add("go");
		System.out.println(sets);
		
		Set<String> sets2 = Sets.newConcurrentHashSet();
		sets2.add("java");
		sets.removeAll(sets2);
		
		System.out.println(sets);
		
		Set<String> sets3 = Sets.newConcurrentHashSet();
		sets3.removeAll(sets2);
		System.out.println(sets3);
		
		if(!sets3.contains("java")) {
			System.out.println("Hello world");
		}
	}
}
