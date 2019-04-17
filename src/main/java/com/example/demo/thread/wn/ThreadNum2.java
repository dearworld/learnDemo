package com.example.demo.thread.wn;

public class ThreadNum2 extends Thread {

	public void run() {

		for (int i = 0; i < 5; i++) {
			synchronized (MyLock.obj) {
				System.out.println(2);
				MyLock.obj.notify();
				try {
					MyLock.obj.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
