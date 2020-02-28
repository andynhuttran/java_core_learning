package com.javalearning.multithread.cyclicbarrier_demo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class WorkingTask implements Runnable {
	
	private int duration;
	private CyclicBarrier barrier;
	private String taskName;
	
	public WorkingTask(int duration, CyclicBarrier barrier, String taskName){
		this.duration = duration;
		this.barrier = barrier;
		this.taskName = taskName;
	}

	
	@Override
	public void run() {
		
		System.out.println(taskName + " do first part: " + duration);
		try {
			Thread.sleep(duration);
			barrier.await();
		} catch (InterruptedException | BrokenBarrierException e ) {
			e.printStackTrace();
		}
		
		doLastPart(); //task is resumed after all barrier called await
	}
	
	private void doLastPart(){
		System.out.println(taskName + " do last parts, and finish...");
	}
	
	
	
}
