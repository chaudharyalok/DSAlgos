package com.alok.rule21.concurrency;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumer {

	private Object notEmpty = new Object();
	private Object notFull = new Object();
	
	int max = 16;
	
	private Queue<String> queue = new LinkedList<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		

	}
	
	private static void blockingQueue(){
		
		BlockingQueue<String> queue = new ArrayBlockingQueue<>(10);
		
		final Runnable producer = () -> {
			while(true){
				try {
					queue.put("abc");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		new Thread(producer).start();
		new Thread(producer).start();
		
		final Runnable consumer = () -> {
			while(true){
				String item;
				try {
					item = queue.take();
					System.out.println(item);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		};
		
		new Thread(consumer).start();
		new Thread(consumer).start();
		
		try {
			Thread.sleep(1000l);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// 
	private synchronized void produce(String item){
		
		while(queue.size() == max){
			try {
				notFull.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		queue.add(item);
		notEmpty.notifyAll();
	}
	
	private synchronized String consumer(){
		
		while(queue.size() == 0){
			try {
				notEmpty.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		String item = queue.remove();
		notFull.notify();
		return item;
	}

}
