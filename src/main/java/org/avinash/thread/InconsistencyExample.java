package org.avinash.thread;

public class InconsistencyExample extends Thread {
	int total = 0;

	public void run() {
		synchronized (this) {
			for (int i = 0; i <= 100; i++) {
				total = total+i;
			}
			this.notify();	
		}
	}

}

class Call {
	public void callThread() throws InterruptedException {
		InconsistencyExample iEObj = new InconsistencyExample();
		iEObj.start();
		//Thread.sleep(10000);
		synchronized(iEObj) {
			iEObj.wait(1000);
		}

		//iEObj.join();
		//Thread.sleep(10000);
		System.out.println(iEObj.total);
	}
}