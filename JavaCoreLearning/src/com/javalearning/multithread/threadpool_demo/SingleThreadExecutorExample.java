package com.javalearning.multithread.threadpool_demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutorExample {
	
	public static void main(String[] args) {
		//ExecutorService executor = Executors.newSingleThreadExecutor();
		
		ExecutorService executor = Executors.newCachedThreadPool();
		
		for (int i = 0; i < 9; ++i){
			Task task = new Task("Task-" + (i+1));			
			executor.execute(task);
		}
		
		executor.shutdown();		
		System.out.println("Finished all threads 2");
	}
}
