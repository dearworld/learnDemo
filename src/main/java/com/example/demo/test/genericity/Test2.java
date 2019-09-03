package com.example.demo.test.genericity;

//泛型方法
public class Test2 {
	public static void main(String[] args) {
		variableType(1);
		variableType(1l);
		variableType(1.0);
		variableType("赵丽颖");
	}
	
	
	public static <T> void variableType(T t) {
		System.out.println(t.getClass());
	}
}
