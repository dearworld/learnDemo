package com.example.demo.thread.basic;

public class MyThread extends Thread {
	
	public void run() {
		for (int i = 0; i < 50; i++) {
			System.out.println(this.getName()+":"+i);
		}
	}
	
}
