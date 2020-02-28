package com.javalearning.multithread.callable_runnable_future;

import java.util.Random;
import java.util.concurrent.Callable;

public class WorkingTaskCallable implements Callable<String> {

	
	
	@Override
	public String call() throws Exception {
		
		int value = new Random().nextInt(5);
		
		Thread.sleep(value*1000);
		
		return String.format(Thread.currentThread().getName() + " stopped " + value*1000 + " seconds");
	}

}
