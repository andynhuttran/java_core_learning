package com.javalearning.java8.stream_example;

import java.util.List;
import java.util.stream.Collectors;

import com.javalearning.java8.data.DataSource;
import com.javalearning.java8.data.Developer;

public class MainDemo {

	public static void main(String[] args) {
		
		List<Developer> devs = DataSource.getDevelopers();
		
		System.out.println("---------Filter and select one dev-----------");
		Developer dev  = devs.stream()
							.filter(d -> {
								if (d.getSalary() > 100000 && d.getAge() > 30) {
									return true;
								}
								return false;
							}) //filter data with multiple condition
							.findAny() //get first one found
							.orElse(new Developer()); //return empty dev if not found
		System.out.println(dev);
		
		
		System.out.println("\n---------Filter and convert to another dev-----------");
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
		
		newList.forEach(System.out::println);	
		
		System.out.println("\n--------Original list------------");
		devs.forEach(System.out::println);
		
	}
	


}
