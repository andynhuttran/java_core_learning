package com.javalearning.multithread.threadpool_demo;

public class Task implements Runnable {
	
	private String name;
	
	public Task(String name){
		this.name = name;
	}

	
	@Override
	public void run() {
		String threadName = Thread.currentThread().getName();
		
		System.out.println(threadName + " - Starting task: " + this.name);
		processTask();		
		System.out.println(threadName + " - Finish task: " + this.name);		
	}
	
	private void processTask(){
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
}
