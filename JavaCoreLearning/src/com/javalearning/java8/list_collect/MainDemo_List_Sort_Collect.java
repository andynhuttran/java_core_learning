package com.javalearning.java8.list_collect;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.javalearning.java8.data.DataSource;
import com.javalearning.java8.data.Developer;

public class MainDemo_List_Sort_Collect {
	
	public static void main(String[] args) {
		
		
		List<Developer> devs = DataSource.getDevelopers();
		
		System.out.println("\n-----------Full list---------------");
		devs.forEach(System.out::println);
		
		System.out.println("\n------------Convert to map--------------");
		Map<Integer, String> map = devs.stream()
						.sorted(Comparator.comparingInt(d -> d.getAge()))
						.collect(								
								Collectors.toMap(d -> d.getAge(), d -> d.getName() //age is key, name is value
										,(oldKey, newKey) -> newKey //if age is duplicated, choise new one
										,LinkedHashMap::new //return a LinkedHashMap
								));
		
		System.out.println("map : " + map);
		
		
		System.out.println("\n------------Sort filter and pick name--------------");
		List<String> list = devs.stream()									
									.sorted((d1, d2) -> {
										return d2.getAge() - d1.getAge();
									}) //sort by age						
									.filter(d -> {
										return d.getAge() > 30;
									}) //filter age > 30									
									.map(d -> {
										return d.getName();
									}) //pick age
									.collect(Collectors.toList()); //to list
		
		list.forEach(System.out::println);
						
		
		
	}
	
	
}
