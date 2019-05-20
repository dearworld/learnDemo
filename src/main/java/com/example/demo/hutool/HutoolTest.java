package com.example.demo.hutool;

import cn.hutool.core.bean.BeanUtil;

public class HutoolTest {
	public static void main(String[] args) {
		Person person = new Person();
		person.setName("赵丽颖");
		person.setAge(18);
		Student student = new Student();
		BeanUtil.copyProperties(person, student);
		System.out.println(person);
		System.out.println(student);
	}
}	

class Person {
	private String name;
	private Integer age;

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

	@Override
	public String toString() {
		return "person [name=" + name + ", age=" + age + "]";
	}
}


class Student extends Person {
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + "]";
	}
	
}