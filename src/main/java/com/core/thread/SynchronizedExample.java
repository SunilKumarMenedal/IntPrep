package com.core.thread;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class SynchronizedExample {

	public static void main(String ar[]) {
		Consumer<String> func = (String param) -> {
			synchronized (SynchronizedExample.class) {
				System.out.println(Thread.currentThread().getName() + " step 1: " + param);

				try {
					Thread.sleep((long) (Math.random() * 1000));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + " step 2: " + param);
			}
		};
		
		Supplier<String> proc = ()->{
			return "param_Supplier";
		};
		
		 Thread thread1 = new Thread(() -> {
		        func.accept("Parameter");
		    }, "Thread 1");

		    Thread thread2 = new Thread(() -> {
		        func.accept("Parameter1");
		    }, "Thread 2");

		    thread1.start();
		    thread2.start();
		  }
		}
