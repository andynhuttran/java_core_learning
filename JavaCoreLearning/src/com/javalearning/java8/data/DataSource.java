package com.javalearning.java8.data;

import java.util.ArrayList;
import java.util.List;

public class DataSource {
	
	public static List<Developer> getDevelopers() {

		List<Developer> result = new ArrayList<Developer>();

		result.add(new Developer("mkyong", 33, 70000));
		result.add(new Developer("alvin", 20, 80000));
		result.add(new Developer("jason", 30, 100000));
		result.add(new Developer("iris", 55, 170000));
		
		return result;

	}
}
