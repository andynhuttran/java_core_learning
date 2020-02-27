package com.javalearning.multithread.synchronized_demo;

public class WorkingThread extends Thread {

	SharedObject so;
	String threadName;
	
	public WorkingThread(SharedObject so, String threadName){
		this.so = so;
		this.threadName = threadName;
	}
	
	@Override
	public void run(){
		so.doSomething(threadName);
	}
	
}
