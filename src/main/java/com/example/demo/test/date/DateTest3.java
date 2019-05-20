package com.example.demo.test.date;

import java.util.Map;

import org.junit.Test;

import cn.hutool.core.bean.BeanUtil;


public class DateTest3 {
		
	@Test
	public void test() {
		Person person = new Person("赵丽颖", 18, "女");
		Map<String, Object> map = BeanUtil.beanToMap(person);
		System.out.println(map);
		map.put("phone", "10086");
		Person person2 = BeanUtil.mapToBean(map,Person.class, false);
		System.out.println(person2);
		
		
	}
}

class Person{
	private String name;
	private Integer age;
	private String gender;
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Person(String name, Integer age, String gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}
	
	
}
