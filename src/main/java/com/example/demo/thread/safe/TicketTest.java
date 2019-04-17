package com.example.demo.thread.safe;

public class TicketTest {
	public static void main(String[] args) {
		
		TicketThread ticketThread = new TicketThread();
		Thread thread = new Thread(ticketThread);
		thread.setName("窗口1");
		Thread thread2 = new Thread(ticketThread);
		thread2.setName("窗口2");
		thread.start();
		thread2.start();
	}
}
