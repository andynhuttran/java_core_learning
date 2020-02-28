package com.javalearning.multithread.threadjoin_demo;

public class MainDemo {
	public static void main(String[] args) {
		
		IService s1 = new ServiceOne();
		IService s2 = new ServiceTwo();
		IService s3 = new ServiceThree();
		
		Thread t1 = new Thread(s1);
		Thread t2 = new Thread(s2);
		Thread t3 = new Thread(s3);
		
		t1.start();
		t2.start();
		t3.start();
		
		try {
			System.out.println("Waiting for 3 services have started ... ");
			t1.join();
			t2.join();
			t3.join();
			System.out.println("Starting main Thread ... ");
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
