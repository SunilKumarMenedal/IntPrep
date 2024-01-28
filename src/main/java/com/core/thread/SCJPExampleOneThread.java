package com.core.thread;

public class SCJPExampleOneThread {

	public static void main(String[] args) {

		Runnable run = ()->{
			for (int i = 0; i < 100; i++) {
				try {
					if(i%10 == 0) {
						System.out.println("value of 10 mod i"+i);
					}
					Thread.sleep(1L*1000L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		};
		
		Thread t1 = new Thread(run, "thread One");
		t1.setPriority(8);
		t1.start();
	}

}
