package com.core.thread;

public class ThreadExample1 {

	// Extending thread class approach
	public static class ThreadOne extends Thread{
		
		@Override
		public void run() {
			System.out.println("Extending Thread");
		}
	}
	
	// Implementing Runnable approach
	public static class ThreadTwo implements Runnable{

		@Override
		public void run() {
			System.out.println("Implementing Runnable");
			try {
				Thread.sleep(5000);
				System.out.println("After Sleep");
			}catch(InterruptedException ie) {
				System.out.println("Inside Exception");
			}
		}
	}
	
	public static void main(String []args) {
		ThreadOne firstThread = new ThreadOne();
		firstThread.start();
		
		ThreadTwo threadTwo = new ThreadTwo();
		Thread secondThread = new Thread(threadTwo);
		secondThread.start();
		
		//Anonymous class approach
		Runnable runn = new Runnable() {
			@Override
			public void run() {
				System.out.println("Anynomous class Runnable");
			}
		};
		
		Thread thirdThread = new Thread(runn);
		thirdThread.start();
		
		//functional programming approach
		Runnable funcRunnable = ()->{
			System.out.println("Lambda expression approach");
		};
		
		Thread fourthThread = new Thread(funcRunnable);
		fourthThread.start();
		
	}
	
}
