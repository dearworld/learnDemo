package com.example.demo.thread.basic;

public class RunnableFor2 implements Runnable {

	@Override
	public void run() {
		for (int i = 50; i < 100; i++) {
			System.out.println(Thread.currentThread().getName()+":"+i);
		}
	}

}
