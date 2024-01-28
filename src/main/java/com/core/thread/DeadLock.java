package com.core.thread;

public class DeadLock {
	
	static class SharedResource{
		int value;
		
		public SharedResource(int val) {
			value = val;
		}
		
		synchronized void method1(SharedResource sr) {
			System.out.println("Method1  "+ Thread.currentThread().getName()+" value's value is:  "+this.value);
			try {
				Thread.sleep(10*100L);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sr.method2(this);
			
			
		}
		synchronized void method2(SharedResource sr) {
			System.out.println("Method2  "+ Thread.currentThread().getName()+" value's value is:  "+this.value);
			try {
				Thread.sleep(10*100L);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			sr.method2(this);
		}
	}
	
	public static void main(String args[]) {
		SharedResource srr1 = new SharedResource(1);
		SharedResource srr2 = new SharedResource(2);
		
		new Thread(()->srr1.method1(srr2), "Thread1").start();
		new Thread(()->srr2.method2(srr1), "Thread2").start();
	}
	
}
