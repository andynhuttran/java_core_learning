package com.javalearning.multithread.folk_join;

import java.util.concurrent.ForkJoinPool;

public class MainDemo {

	public static void main(String[] args) {
		
		ForkJoinPool threadPool = new ForkJoinPool();
		
		CalculateFileSizeTask houseFolder = new CalculateFileSizeTask("/home/cole/Documents/HinhNhaTro");
		CalculateFileSizeTask downloadFolder = new CalculateFileSizeTask("/home/cole/Downloads");
		CalculateFileSizeTask pictureFolder = new CalculateFileSizeTask("/home/cole/Pictures");
		
		
		threadPool.execute(houseFolder);
		threadPool.execute(downloadFolder);
		threadPool.execute(pictureFolder);
		
		System.out.println("houseFolder: " + houseFolder.join()/(1024.0*1024.0f) + " MB");
		System.out.println("downloadFolder: " + downloadFolder.join()/(1024*1024.0f) + " MB");
		System.out.println("pictureFolder: " + pictureFolder.join()/(1024*1024.0f) + " MB");
		

	}

}
