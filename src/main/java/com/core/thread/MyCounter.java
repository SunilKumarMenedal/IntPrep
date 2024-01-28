package com.core.thread;

public class MyCounter {

	private int count =0;
	private static int newCount = 0;
	
	public synchronized void add(int value) {
		this.count = count+value;
	}
	
	public static synchronized void subtract(int value) {
		newCount = newCount-value;
	}
	
	public void syncAdd(int value) {
		synchronized(this) {
			this.count = count+value;
		}
	}
	
	public static void syncSubtract(int value) {
		synchronized (MyCounter.class) {
			newCount = newCount-value;
		}
	}
	
	public int getCount() {
		return this.count;
	}
}
