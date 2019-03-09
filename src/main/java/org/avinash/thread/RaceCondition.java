package org.avinash.thread;

import util.LongWrapper;

public class RaceCondition {
	public static void main(String[] args) {
		Thread t = new Thread(() ->
		{
			System.out.println("I am running in " + Thread.currentThread().getName());
		}
		);
		
		t.start();
//		t.run(); NO
		
	}
	
	public void classsikRaceCondition() {
		LongWrapper longWrapper = new LongWrapper(0l);
		
		Runnable runnable = () -> {
			for (int i = 0; i< 1_000; i++) {
				longWrapper.incrementValue();
			}
		};
		
		Thread[] threads = new Thread[1_000];
		for(int i =0;i<1000;i++) {
			threads[i] = new Thread(runnable);
			threads[i].start();
		}
		
		try {
			for(int i =0;i<1000;i++) {
				threads[i].join();
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Value :" + longWrapper.getValue());
	}

}
