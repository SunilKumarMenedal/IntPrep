package com.core.thread;

public class ThreadA extends Thread {

	int total;
	public void run() {
		synchronized (this) {
			for(int i=0;i<100;i++) {
				total+=i;
				System.out.println("total = "+total);
			}
			try {
				Thread.sleep(10L*1000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			notify();
		}
	}
}
