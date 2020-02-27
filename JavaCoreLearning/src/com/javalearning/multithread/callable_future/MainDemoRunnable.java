package com.javalearning.multithread.callable_future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MainDemoRunnable {

	public static void main(String[] args) {
		
		ExecutorService execute = Executors.newFixedThreadPool(5);
		
		List<Future<?>> list = new ArrayList<Future<?>>();
		
		for (int i = 0; i < 10; ++i) {
			WorkingTaskRunnable task = new WorkingTaskRunnable();			
			Future<?> f = execute.submit(task);
			list.add(f);			
		}
		
		execute.shutdown();
		
		new Thread(new Runnable() {			
			@Override
			public void run() {
				for (Future<?> f : list) {
					try {
						f.get();
						System.out.println(f.toString());
					} catch (InterruptedException | ExecutionException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}				
			}
		}).start();
		
		System.out.println("All threads are finished");        
		

	}

}
