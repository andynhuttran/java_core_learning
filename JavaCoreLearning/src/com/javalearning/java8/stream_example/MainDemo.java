package com.javalearning.java8.stream_example;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.javalearning.java8.data.DataSource;
import com.javalearning.java8.data.Developer;

public class MainDemo {

	public static void main(String[] args) {
		
		List<Developer> devs = DataSource.getDevelopers();
		
		System.out.println("---------Filter and select one dev-----------");
		demoFilterStream(devs);
		
		
		System.out.println("\n---------Filter and convert to another dev-----------");
		demoFilterAndMap(devs);

		
		
	}
	
	
	private static void demoFilterStream(List<Developer> devs) {
		Developer dev  = devs.stream()
				.filter(d -> {
					if (d.getSalary() > 100000 && d.getAge() > 30) {
						return true;
					}
					return false;
				}) //filter data with multiple condition
				.findAny() //get first one found
				.orElse(new Developer()); //return empty dev if not found
		
		dev.setName("cole x");
		System.out.println(dev);
		
		System.out.println("--------------");
		devs.forEach(System.out::println);
	}
	
	
	
	private static void demoFilterAndMap(List<Developer> devs) {
		List<Developer> newList = devs.stream()
				.filter(d -> {
					if (d.getSalary() > 5000 && d.getAge() > 30) {
						return true;
					}
					return false;
				}) //filter by salary and age
				.map(d -> {
					
					Developer dx = new Developer();
					
					dx.setName(d.getName() + " (extended name) " + d.getAge());
					dx.setAge(d.getAge());
					dx.setSalary(d.getSalary());
					
					return dx;
				}) //pick name only
				.collect(Collectors.toList());
		
		//newList.get(0).setName("cole 2");
		System.out.println("--------------");
		newList.forEach(System.out::println);
		
		System.out.println("--------------");
		devs.forEach(System.out::println);
	}
	
	
	

}
