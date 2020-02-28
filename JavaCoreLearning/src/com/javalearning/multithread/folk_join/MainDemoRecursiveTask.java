package com.javalearning.multithread.folk_join;

import java.util.concurrent.ForkJoinPool;

public class MainDemoRecursiveTask {

	public static void main(String[] args) {
		
		ForkJoinPool threadPool = new ForkJoinPool();
		
		CalculateFileRecursiveTask folder1 = new CalculateFileRecursiveTask("E:/LOL/32787");
		CalculateFileRecursiveTask folder2 = new CalculateFileRecursiveTask("E:/LOL/32787");
		CalculateFileRecursiveTask folder3 = new CalculateFileRecursiveTask("E:/LOL/32787");
		
		
		threadPool.execute(folder1);
		threadPool.execute(folder2);
		threadPool.execute(folder3);
		
		System.out.println("houseFolder: " + folder1.join()/(1024.0*1024.0f) + " MB");
		System.out.println("downloadFolder: " + folder2.join()/(1024*1024.0f) + " MB");
		System.out.println("pictureFolder: " + folder3.join()/(1024*1024.0f) + " MB");
		
		System.out.println("--End main thread");
	}

}
