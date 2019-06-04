package com.example.demo.guava;


import static org.hamcrest.CoreMatchers.instanceOf;

import java.util.List;

import org.junit.Test;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Multimap;


public class Test1 {
	
	@Test
	public void test1() {
		ImmutableList<String> of = ImmutableList.of("a", "b", "c", "d");
		Multimap<String, Object> multimap = ArrayListMultimap.create();
		multimap.put("name", "刘亦菲");
		multimap.put("name","赵丽颖");
		System.out.println(multimap);
	}
}
