package com.example.demo.test.data;

import java.util.Arrays;

import org.apache.commons.beanutils.ConvertUtils;

public class Test1 {
	public static void main(String[] args) {
		String ids = "1,2,3,4,5";
		String[] split = ids.split(",");
		Long[] idsArr = (Long[]) ConvertUtils.convert(split, Long.class);
		System.out.println(idsArr);
		System.out.println(Arrays.toString(idsArr));
		System.out.println(Arrays.asList(idsArr));
		
		
		Person person = new Person();
		person.setName("赵丽颖");
		person.setAge(18);
		System.out.println(person);
	}
}	
