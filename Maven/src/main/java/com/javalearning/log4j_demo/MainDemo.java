package com.javalearning.log4j_demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainDemo {

	private static final Logger logger = LogManager.getLogger(MainDemo.class);
	//private static final Logger logger = LogManager.getRootLogger();
	
	private String message;
	
	public MainDemo(String message) {
		this.message = message;
		
		logger.info("Message is: " + message);
	}
	
	
	public void proccessMessaage() {
		message = "Hello " + message;
		logger.info("New message is: " + message);
	}
	
	
	public void doBadThing() {
		Exception e = new Exception("do bad thing");
		logger.error("bad thing", e);
	}
	
	public static void main(String[] args) {
		
		System.out.println("start");
		long timex = System.currentTimeMillis();
		
		for (int i = 0; i < 200; ++i) {
			MainDemo d = new MainDemo("Cole: " + i);
			
			d.proccessMessaage();
			
			d.doBadThing();
		}
		
		long time = System.currentTimeMillis() - timex;
		
		System.out.println("time: " + time);
		
	}

}
