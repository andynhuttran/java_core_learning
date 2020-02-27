package com.javalearning.multithread.synchronized_demo;

public class MainDemo {

	public static void main(String[] args) {
		
		System.out.println("--Begin main thread");
		
		SharedObject so1 = new SharedObject();
		
		WorkingThread wt1 = new WorkingThread(so1, "Working Thread 1");
		WorkingThread wt2 = new WorkingThread(so1, "Working Thread 2");
		WorkingThread wt3 = new WorkingThread(so1, "Working Thread 3");
		
		wt1.start();
		wt2.start();
		wt3.start();		
		
		System.out.println("--End main thread");

	}

}
