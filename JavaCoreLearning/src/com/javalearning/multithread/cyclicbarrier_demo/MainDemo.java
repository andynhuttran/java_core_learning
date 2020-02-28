package com.javalearning.multithread.cyclicbarrier_demo;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MainDemo {

	public static void main(String[] args) {
		int parties = 3;
		CyclicBarrier barrier = new CyclicBarrier(parties+1);
		
		for (int i = 0; i < parties; ++i){
			int rd = new Random().nextInt(5)+1;
			WorkingTask task = new WorkingTask(rd*1000, barrier, "Task-"+(i+1));
			
			new Thread(task).start();
		}
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				
				try {
					System.out.println("Subtask do first path");
					barrier.await();
					Thread.sleep(2000);
					System.out.println("Subtask do last part, and finish...");
					
				} catch (InterruptedException | BrokenBarrierException e) {
					e.printStackTrace();
				}
				
			}
		}).start();
		

	}

}
