package com.javalearning.multithread.callable_runnable_future;

import java.util.Random;
import java.util.concurrent.Callable;

public class WorkingTaskRunnable implements Runnable {

	
	
	@Override
	public void run() {
		int value = (new Random().nextInt(5))+1;
		
		try {
			Thread.sleep(value*1000);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
		
		String msg = String.format(Thread.currentThread().getName() + " stopped " + value*1000 + " seconds");
		System.out.println(msg);
		
	}

	
	
	

}
