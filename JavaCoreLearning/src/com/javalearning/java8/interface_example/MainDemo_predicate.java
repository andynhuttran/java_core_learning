package com.javalearning.java8.interface_example;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class MainDemo_predicate {

	public static void main(String[] args) {
		
		
		List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5);
		Predicate<Integer> intPredicate = (i) -> {
			if (i%2 == 0) return true;
			return false;
		};
		usingListAndPredicate(intList, intPredicate);
		
		System.out.println("------------------");
		
		List<String> stringList = Arrays.asList("Java", "C#", "Python", "C++", "Javascript");
		Predicate<String> stringPredicate = (str) -> {
			if (str.length() > 3) return true;
			return false;
		};
		usingListAndPredicate(stringList, stringPredicate);

	}
	
	
	private static <T> void usingListAndPredicate(List<T> list, Predicate<T> predicate) {
		list.parallelStream()
			.filter(predicate)
			.forEach(System.out::println);
	}

}
