package com.example.demo.thread.basic;

public class RunnableTest {
	public static void main(String[] args) {
		
		Thread thread = new Thread(new RunnableFor1());
		thread.setName("线程1");
		
		Thread thread2 = new Thread(new RunnableFor2());
		thread2.setName("线程2");
		
		thread.start();
		thread2.start();
	}
}
