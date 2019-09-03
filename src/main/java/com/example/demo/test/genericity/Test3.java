package com.example.demo.test.genericity;

import java.util.Date;

//泛型接口的定义和使用
public class Test3 {
	public static void main(String[] args) {
		ShowTest showTest = new ShowTest();
		System.out.println(showTest.getClass());
		showTest.show("java", new Date());
	}
}

interface Show<T,U>{
	void show(T t,U u);
}

class ShowTest implements Show<String,Date>{

	@Override
	public void show(String t, Date u) {
		System.out.println(t);
		System.out.println(u);
	}
	
}