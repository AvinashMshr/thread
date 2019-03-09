package org.avinash.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutoExample {

	private static ExecutorService emailExecutor = Executors.newFixedThreadPool(1);

	static void getData() {
		List<Future<String>> futures = new ArrayList<Future<String>>();
		for (int i = 0; i < 10; i++) {
			final Future<String> future = emailExecutor.submit(new MyInfoCallable(i));
			futures.add(future);
		}
		for (Future<String> f : futures) {
			try {
				System.out.println(f.get());
			}catch (InterruptedException | ExecutionException ex) {
			}
		}
		System.out.println("Size :" + futures.size());
	}

	public static String getMYInfo(int i) {
		String somevav = "success";
		try {
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (i == 0) {
			somevav = "0";
		} else if (i == 1) {
			somevav = "1";
		} else if (i == 2) {
			somevav = "2";
		} else if (i == 3) {
			somevav = "3";
		} else if (i == 4) {
			somevav = "4";
		} else if (i == 5) {
			somevav = "5";
		} else if (i == 6) {
			somevav = "6";
		} else if (i == 7) {
			somevav = "7";
		} else if (i == 8) {
			somevav = "8";
		} else if (i == 9) {
			somevav = "9";
		}
		return somevav;
	}

	private static class MyInfoCallable implements Callable<String> {

		int i;

		public MyInfoCallable(int i) {
			this.i = i;
		}

		@Override
		public String call() throws Exception {
			return getMYInfo(i);
		}

	}

}

