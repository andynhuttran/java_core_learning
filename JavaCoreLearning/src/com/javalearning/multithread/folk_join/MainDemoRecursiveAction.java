package com.javalearning.multithread.folk_join;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.atomic.AtomicLong;

public class MainDemoRecursiveAction {

	public static void main(String[] args) {
		
		ForkJoinPool threadPool = new ForkJoinPool();
		
		AtomicLong sizeFolder1 = new AtomicLong(0);
		CalculateFileRecursiveAction folder1 = new CalculateFileRecursiveAction("E:/LOL/32787", sizeFolder1);
		
		AtomicLong sizeFolder2 = new AtomicLong(0);
		CalculateFileRecursiveAction folder2 = new CalculateFileRecursiveAction("E:/LOL/32787", sizeFolder2);
		
		AtomicLong sizeFolder3 = new AtomicLong(0);
		CalculateFileRecursiveAction folder3 = new CalculateFileRecursiveAction("E:/LOL/32787", sizeFolder3);
		
		
		
		threadPool.execute(folder1);
		threadPool.execute(folder2);
		threadPool.execute(folder3);
		
		System.out.println("houseFolder: " + sizeFolder1.get()/(1024.0*1024.0f) + " MB");
		System.out.println("downloadFolder: " + sizeFolder2.get()/(1024*1024.0f) + " MB");
		System.out.println("pictureFolder: " + sizeFolder3.get()/(1024*1024.0f) + " MB");
		
		System.out.println("--End main thread");

	}

}
