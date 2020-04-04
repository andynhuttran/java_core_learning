package com.javalearning.java8.comparator_sort;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.javalearning.java8.data.DataSource;
import com.javalearning.java8.data.Developer;

public class MainDemo {
	
	public static void main(String[] args) {
		List<Developer> developers = DataSource.getDevelopers();
		
		
		System.out.println("Before Sort");
		for (Developer dev : developers) {
			System.out.println(dev);
		}
		
		//before java 8
		Collections.sort(developers, new Comparator<Developer>() {
			@Override
			public int compare(Developer o1, Developer o2) {				
				return o1.getAge()-o2.getAge();
			}
		});
		
		
		
		//java-8
    Collections.sort(developers, (o2, o1)->o1.getName().compareTo(o2.getName()) ); //java 8, way 1
		
		developers.sort((d1, d2) -> d1.getAge()-d2.getAge()); //java 8, way 2
		
		developers.sort(new Comparator<Developer>() { //java 8, way 3
			@Override
			public int compare(Developer o1, Developer o2) {
				return o1.getSalary()-o2.getSalary();
			}
		});
		
		System.out.println("---------------------");
		System.out.println("After Sort");
		//java 8
		developers.forEach((d) -> System.out.println(d));
		
		
	}
	
	
}
