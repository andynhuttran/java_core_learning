package com.javalearning.java8.forEach_Map_List;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.javalearning.java8.data.DataSource;
import com.javalearning.java8.data.Developer;

public class MainDemo_List {
	
	public static void main(String[] args) {
		List<Developer> devs = DataSource.getDevelopers();
		
		//old version
		System.out.println("-------before java 8");
		for (Developer dev : devs){
			System.out.println(dev);
		}
		
		//java8
		System.out.println("----------java 8 - print 1");
		devs.forEach(dev -> System.out.println(dev));
		System.out.println("----------java 8 - print 2");
		devs.forEach(System.out::println);
		
		
		System.out.println("----------java 8 - filter 1 by lamda");
		devs.forEach(dev -> {
			if (dev.getAge() > 30){
				System.out.println(dev);
			}
		});
		
		System.out.println("----------java 8 - filter 2 by stream");
		List<Developer> subList = devs.stream()
								.filter(d -> d.getAge() > 30)
								.collect(Collectors.toList());		
		subList.forEach(System.out::println);
		
	}
}
