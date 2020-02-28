package com.javalearning.multithread.countdownlatch_demo;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class MainDemo {
	public static void main(String[] args) {
		
		CountDownLatch countDownLatch = new CountDownLatch(3); //1. we need to wait 3 thread before process other threads
		
		IService s1 = new ServiceOne(countDownLatch);
		IService s2 = new ServiceTwo(countDownLatch);
		IService s3 = new ServiceThree(countDownLatch);
		
		Thread t1 = new Thread(s1);
		Thread t2 = new Thread(s2);
		Thread t3 = new Thread(s3);
		
		t1.start();
		t2.start();
		t3.start();
		
		//2. create new thread, and run it after above threads are finished
		new Thread(new Runnable() {			
			@Override
			public void run() {
				try {
					System.out.println("Waiting for 3 services have started ... ");
					countDownLatch.await(); //wait until countDownLatch = 0
					System.out.println("Starting... " + Thread.currentThread().getName());
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		
		//3. create new thread, and run without caring any threads
		new Thread(new Runnable() {			
			@Override
			public void run() {
				try {
					int rd = new Random().nextInt(3);
					Thread.sleep(rd*1000);
					System.out.println("Independence thread..." + rd);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		
		
		System.out.println("--End main thread");
	}
}
