package org.avinash.thread;

import junit.framework.TestCase;

public class InconsistencyExampleTest extends TestCase {
	public void test() throws InterruptedException {
		Call call = new Call();
		call.callThread();
	}

}
