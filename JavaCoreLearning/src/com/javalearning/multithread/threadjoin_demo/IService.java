package com.javalearning.multithread.threadjoin_demo;

public abstract class IService implements Runnable {

	public abstract void start();
	
	@Override
	public void run() {
		start();
	}
}
