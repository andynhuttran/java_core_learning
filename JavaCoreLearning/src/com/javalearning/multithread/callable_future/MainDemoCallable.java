package com.javalearning.multithread.callable_future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MainDemoCallable {

	public static void main(String[] args) {
		
		ExecutorService execute = Executors.newFixedThreadPool(5);
		
		List<Future<String>> list = new ArrayList<Future<String>>();
		
		for (int i = 0; i < 10; ++i) {
			WorkingTaskCallable task = new WorkingTaskCallable();			
			Future<String> f = execute.submit(task);
			list.add(f);			
		}
		
		
		
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (Future<String> f : list) {			
					try {
						String msg = f.get();
						System.out.println(msg);
						
					} catch (InterruptedException | ExecutionException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
		
		execute.shutdown();
		System.out.println("finished all threads");

	}

}
