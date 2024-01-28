package com.core.thread;

public class StoppingThreadExample {
	public static void main(String []args) {
		MyRunnable runnableThread = new MyRunnable();
		
		
		Thread thread1 = new Thread(runnableThread);
		thread1.start();
		try {
			Thread.sleep(10L*1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		runnableThread.stop();
		
	}
}

class MyRunnable implements Runnable {

	private boolean doStop = false;
	
	private synchronized boolean keepRunning() {
		return this.doStop == false;
	}
	
	public synchronized void stop() {
		this.doStop = true;
	}
	
	@Override
	public void run() {
		while(keepRunning()) {
			System.out.println("Running");
		
			try {
				Thread.sleep(3L*1000L);
			}catch(InterruptedException ie) {
				ie.printStackTrace();
			}
		}
	}

}