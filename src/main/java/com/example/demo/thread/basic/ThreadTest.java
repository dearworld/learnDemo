package com.example.demo.thread.basic;

public class ThreadTest {
	public static void main(String[] args) {
		
		MyThread thread = new MyThread();
		thread.setName("线程A");
		
		MyThread2 thread2 = new MyThread2();
		thread2.setName("线程B");
		
		thread.start();
		thread2.start();
	}
}
