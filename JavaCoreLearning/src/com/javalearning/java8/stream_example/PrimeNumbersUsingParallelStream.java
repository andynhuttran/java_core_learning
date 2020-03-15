package com.javalearning.java8.stream_example;

import java.util.List;
import java.util.stream.IntStream;


public class PrimeNumbersUsingParallelStream {

	public static void main(String[] args) {
		
		
		long time = System.currentTimeMillis();
		
		long count = IntStream.rangeClosed(1, 1000000)
					.parallel()  //loop stream by multiple thread, make program faster
					.filter(n -> isPrime(n)) //check filter
					.peek(d -> {
						if (d < 20) System.out.println(d);
					}) //use to show debug
					.count();
		
		long deltaTime = System.currentTimeMillis()-time;
		
		System.out.println("count: " + count);
		System.out.println("delta time: " + deltaTime/1000.0f + " seconds");

	}
	
	
	static boolean isPrime(int n) {
		if (n == 1) return false;
		
		//loop from 2 to n/2, then find any number is matched by division evenly
		boolean result = !IntStream.rangeClosed(2, n/2).anyMatch(i -> n%i == 0);
				
		return result;
	}

}
