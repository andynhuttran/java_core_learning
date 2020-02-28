package com.javalearning.multithread.countdownlatch_demo;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class ServiceTwo extends IService {


	public ServiceTwo(CountDownLatch countDownLatch) {
		super(countDownLatch);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void start() {
		try {
			
			int rd = new Random().nextInt(5);
			Thread.sleep(rd*1000);
			System.out.println("Done service 2: " + rd);
			countDownLatch.countDown(); //count down (- 1) after finish a thread
		}
		catch (InterruptedException e){
			e.printStackTrace();
		}
	}

}
