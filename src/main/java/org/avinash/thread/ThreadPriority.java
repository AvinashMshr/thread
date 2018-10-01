package org.avinash.thread;

public class ThreadPriority {

	public void showPriority()
	{
		System.out.println(Thread.currentThread().getPriority());
		//Thread.currentThread().setPriority(7);
		System.out.println(Thread.currentThread().getPriority());
		Thread thread = new Thread();
		thread.start();
		System.out.println(thread.getPriority());
	}
}
