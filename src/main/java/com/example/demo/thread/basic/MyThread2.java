package com.example.demo.thread.basic;

public class MyThread2 extends Thread {
	public void run() {
		for (int i = 50; i < 100; i++) {
			System.out.println(this.getName()+":"+i);
		}
	}
}
