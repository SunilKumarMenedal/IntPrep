package com.core.thread;

public class TestSync {

	public static void main(String[] args) {
	
		MyCounter counter = new MyCounter();
		Runnable myRun1 = ()->{
			for(int i=0;i<10;i++) {
				counter.add(i);
				System.out.println("inside "+Thread.currentThread().getName()+" "+i);
			}
		};

		Thread th1 = new Thread(myRun1,"thread 1");
		Thread th2 = new Thread(myRun1, "thread 2");
		
		th1.start();
		th2.start();
		System.out.println(counter.getCount());
		
	}

}
