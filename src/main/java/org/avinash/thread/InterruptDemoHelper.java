package org.avinash.thread;

public class InterruptDemoHelper {
	public void demoHelper() {
		InterruptDemo iD = new InterruptDemo();
		iD.start();
		//iD.interrupt();
		System.out.println("End of Helper method");
	}

}
