package com.example.demo.test.string;

import java.util.Arrays;
import java.util.List;

public class StringTest2 {
	public static void main(String[] args) {
		
		String[] strArr = {"a","b","c","d","e","f","g"};
		System.out.println(strArr.length);
		
		String[] dest = new String[5];
		System.arraycopy(strArr, 0, dest, 0, dest.length);
		List<String> list = Arrays.asList(dest);
		System.out.println(list);
	}
}
