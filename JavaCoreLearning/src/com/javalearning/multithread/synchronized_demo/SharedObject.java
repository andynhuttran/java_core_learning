package com.javalearning.multithread.synchronized_demo;

public class SharedObject {
	
	
	public synchronized void doSomething(String threadName){
		
		for (int i = 0; i < 5; ++i){
			System.out.println(i + " - " + threadName);
		}
		
	}

}
