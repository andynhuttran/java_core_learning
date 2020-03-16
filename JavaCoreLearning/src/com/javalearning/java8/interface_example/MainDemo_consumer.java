package com.javalearning.java8.interface_example;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class MainDemo_consumer {
	public static void main(String[] args) {
		
		List<String> names = Arrays.asList("A", "B", "C", "D", "E");		
		Consumer<String> consumer1 = (str) -> {
			System.out.println("Hello: " + str);
		};
		useConsumer(names, consumer1);
		
		System.out.println("-----------------");
		
		List<Integer> nums = Arrays.asList(2, 4, 6, 8, 10);		
		Consumer<Integer> consumer2 = (i) -> {
			System.out.println("double: " + i*2);
		};
		useConsumer(nums, consumer2);

	}
	
	
	private static <T> void useConsumer(List<T> list, Consumer<T> consumer) {
		list.stream().forEach(consumer);
	}
	
}
