package com.core.thread;

import java.util.HashSet;
import java.util.Set;

class Show {

	// Volatile is Atomic 
	private static volatile Show raceCon;
	
	private Set<String> availableSeats;
	
	public synchronized static Show getInstance() {
		if(raceCon==null) {
			raceCon = new Show();
		}
		return raceCon;
	}
	
	private Show() {
		availableSeats = new HashSet<String>();
		availableSeats.add("1A");
		availableSeats.add("1B");
	}
	
	public boolean bookSeat(String seat) {
		synchronized(this) {
		return availableSeats.remove(seat);}
	}
}

public class RaceCondition{
	public static void main(String args[]) {
		RaceCondition race = new RaceCondition();
		race.go();
	}
	/*
	 * Runnable run1 = ()->{ synchronized(this){ ticketAgentBooks("1A");
	 * ticketAgentBooks("1B"); } };
	 * 
	 * Runnable run2 = ()->{ synchronized(this){ ticketAgentBooks("1A");
	 * ticketAgentBooks("1B"); } };
	 */
	public void go() {
		new Thread(()->{
			ticketAgentBooks("1A");
			ticketAgentBooks("1B");
		},"thread1").start();
		
		new Thread(()->{
			ticketAgentBooks("1A");
			ticketAgentBooks("1B");
		},"thread2").start();
		
	}
	public void ticketAgentBooks(String seat) {
	      // get the one instance of the Show Singleton
	      Show show = Show.getInstance();
	      // book a seat and print
	      System.out.println(Thread.currentThread().getName() + ": "
	         + show.bookSeat(seat));
	   }
	
}