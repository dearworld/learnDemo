package com.example.demo.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.util.StringUtils;

public class StreamTest {
	
	public static void main(String[] args) {
		List<String> strings = Arrays.asList("java","python","go");
		List<String> list = strings.stream().filter(string -> !StringUtils.isEmpty(string)).collect(Collectors.toList());
		System.out.println(list);
		
		Random random = new Random();
		random.ints().limit(10).forEach(System.out::println);
		
		
	}
}
