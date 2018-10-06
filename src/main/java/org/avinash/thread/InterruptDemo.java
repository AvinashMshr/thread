package org.avinash.thread;

public class InterruptDemo extends Thread {
	@Override
	public void run() {
		try {
			for (int i = 0; i < 10; i++) {
				System.out.println("Sleeping Tread");
				Thread.sleep(2000);
			}
		} catch (InterruptedException ex) {
			System.out.println(ex.getMessage());
		}
	}

}
