package com.example.demo.thread.safe;

public class TicketThread implements Runnable {

	private int ticket = 10;

	@Override
	public void run() {
		while (true) {
/*			synchronized (this) {
				method();
			}*/
			method1();
		}
	}

	private void method() {
		if(ticket>0) {
			System.out.println(Thread.currentThread().getName()+":"+ticket--);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private synchronized void method1() {
		if(ticket>0) {
			System.out.println(Thread.currentThread().getName()+":"+ticket--);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
