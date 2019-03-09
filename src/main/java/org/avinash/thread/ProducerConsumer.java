package org.avinash.thread;

public class ProducerConsumer {
	private static Object lock = new Object();
	private static int[] buffer = new int[10];
	public static int count = 0;
	public static int cons = 0;
	public static int prod = 0;
	
	static class Producer{
		void produce() {
			synchronized (lock) {
				if(isFull(buffer)) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				buffer[count++] = 1;
				lock.notify();
			}
			System.out.println("Producer " + ++prod);
		}

	}
	
	static class Consumer{
		void consume() {
			synchronized (lock) {
				if(isEmpty(buffer)) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				buffer[--count] = 0;
				lock.notify();;
			}

			System.out.println("Consumer " + ++cons);
		}
	}
	
	static boolean isEmpty(int[] buffer) {
		return count == 0;
	}
	
	static boolean isFull(int[] buffer) {
		return count == buffer.length;
	}

}
