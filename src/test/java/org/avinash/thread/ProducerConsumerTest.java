package org.avinash.thread;

import org.avinash.thread.ProducerConsumer.Consumer;
import org.avinash.thread.ProducerConsumer.Producer;

import junit.framework.TestCase;

public class ProducerConsumerTest extends TestCase {
	
	public void testProducerConsumer() {
		//ProducerConsumer producerConsumer = new ProducerConsumer();
		ProducerConsumer.Producer producer = new Producer();
		ProducerConsumer.Consumer consumer = new Consumer();
		
		Runnable producerTask = () -> {
			for(int i =0 ;i< 50; i++) {
				producer.produce();			
			}
			
			System.out.println("Done producing");
		};
		
		Runnable consumeTask = () -> {
			for(int i =0 ;i< 50; i++) {
				consumer.consume();
			}
			System.out.println("Done consuming");
		};
		
		Thread producerThread = new Thread(producerTask);
		Thread consumerThread = new Thread(consumeTask);
		
		producerThread.start();
		consumerThread.start();
		
		try {
			producerThread.join();
			consumerThread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Done! " + ProducerConsumer.count);
		
	}

}
