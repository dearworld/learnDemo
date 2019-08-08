package com.example.demo.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;

public class UtilTest {
	
	@Test
	public void test1() {
		List<String> list2 = Lists.newArrayList("Java","Python","Go");
		List<String> list1 = null;
		List<String> same = ListUtils.getSame(list1, list2);
		System.out.println(same);
	}
}
