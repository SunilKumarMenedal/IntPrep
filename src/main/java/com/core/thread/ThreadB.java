package com.core.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadB {

	Lock lock = new ReentrantLock();
	Runnable run1 = ()->{
		synchronized (this) {
			
		}
	};
	
	Runnable run2 = ()->{
		synchronized (this) {
			
		}
	};
	 
	public void readTest() {
		boolean locked = lock.tryLock();
		if(locked) {
			try {
				
			}finally {
				lock.unlock();
			}
			
		}
		
	}
	
	public static void main(String arg[]) {
		ThreadA threadA = new ThreadA();
		threadA.start();
		
		synchronized (threadA) {
			try {
				System.out.println("Waiting for thread A to Complete");
				threadA.wait(20L*1000L);
				System.out.println("Waiting for AFTER thread A to Complete");
			}catch(InterruptedException ie) {
				ie.printStackTrace();
				System.out.println("Total is: " + threadA.total);	
			}
			
		}
	}
}
