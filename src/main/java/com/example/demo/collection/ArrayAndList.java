package com.example.demo.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.google.common.collect.Lists;

public class ArrayAndList {
	
	public static void main(String[] args) {
		String[] strArr = {"java","python","go"};
		List<String> list = Arrays.asList(strArr);
		System.out.println(list);
		list.set(2, "C");
		System.out.println(list);
		System.out.println("strArr:"+Arrays.toString(strArr));
		
		List<String> list2 = Lists.newArrayList(Arrays.asList(strArr));
		System.out.println(list2);
		list2.add("C#");
		System.out.println(list2);
		Collections.addAll(list2, "C#");
		System.out.println(list2);	

		String[] arr = {"Java","Python","Go"};
		List<String> list3 = Arrays.asList(arr);
		arr[2] = "C";
		list3.set(1, "C#");
		System.out.println(Arrays.toString(arr));
		System.out.println(list3);
	}
}
