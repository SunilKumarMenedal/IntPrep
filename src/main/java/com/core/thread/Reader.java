package com.core.thread;

public class Reader extends Thread {

	Calculator c;
	public Reader() {
		
	}
	
	public Reader(Calculator cal) {
		c = cal;
	}
	 public void run() {
		 synchronized(c) {
		try {
			System.out.println("Waiting for calculation..."+getName());
			c.wait(10L*100L);
			//notifyAll();
		} catch (InterruptedException e) {}
			System.out.println("Total is: " + c.total);
		}
	}
	public static void main(String[] args) {
		Calculator calculator = new Calculator();

		new Reader(calculator).start();
		new Reader(calculator).start();
		new Reader(calculator).start();
		new Reader(calculator).start();
		//new Thread(calculator).start();
		//new Reader(calculator).start();
		//new Reader().start();
		
		
	}

}

class Calculator implements Runnable{
	
	int total;
	public void run() {
		synchronized(this) {
			for(int i = 0; i < 100; i++) {
				total += i;
				System.out.println("Inside Calculator total -> "+total+" i-> "+i);
			}
		}notifyAll();
	}
}

