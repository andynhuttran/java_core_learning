package com.javalearning.multithread.countdownlatch_demo;

import java.util.concurrent.CountDownLatch;

public abstract class IService implements Runnable {

	protected CountDownLatch countDownLatch;
	
	
	public IService(CountDownLatch countDownLatch){
		this.countDownLatch = countDownLatch;
	}
	
	@Override
	public void run() {
		start();
	}
	
	public abstract void start();
}
