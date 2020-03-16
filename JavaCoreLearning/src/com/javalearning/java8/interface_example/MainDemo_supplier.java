package com.javalearning.java8.interface_example;

import java.util.function.Supplier;

public class MainDemo_supplier {

	public static void main(String[] args) {
		Supplier<Long> sup1 = () -> System.currentTimeMillis();
		useSupplier(sup1);
		
		System.out.println("------------");
		Supplier<Integer> sup2 = () -> 3;
		useSupplier(sup2);
		
		System.out.println("------------");
		Supplier<String> sup3 = () -> "Hello world";
		useSupplier(sup3);
		
		System.out.println("------------");
		Supplier<Double> sup4 = () -> 3.14;
		useSupplier(sup4);
	}
	
	
	private static <T> void useSupplier(Supplier<T> supplier) {
		T t = supplier.get();
		
		if (t instanceof Long) {
			System.out.println("Long: " + t);
		}
		else if (t instanceof Integer) {
			System.out.println("Integer: " + t);
		}
		else if (t instanceof String) {
			System.out.println("String: " + t);
		}
		else {
			System.out.println("Don't know: " + t);
		}
	}
	
	

}
