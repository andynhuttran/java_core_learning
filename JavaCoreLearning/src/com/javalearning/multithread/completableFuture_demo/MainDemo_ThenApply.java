package com.javalearning.multithread.completableFuture_demo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class MainDemo_ThenApply {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "Result from supplyAsync";
		});
		
		
		CompletableFuture<Void> c = completableFuture.thenAccept(m -> {
			String msg = "Get: " + m;
			System.out.println(msg);
		});
		
		new Thread(() -> {
			try {
				c.get();
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}).start();
		
		System.out.println("--End main thread");
	}
	
}
