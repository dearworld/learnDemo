package com.example.demo.test.data.finaltest;

public class FinalArguement {
	public void test1(Person p1) {
		p1 = new Person();
		p1.sleep();
	}
	
	public void test2(final Person p2) {
		//p2 = new Person();
		p2.sleep();
	}
}


class Person{
	public void sleep(){
		System.out.println("睡觉");
	};
}