package com.javalearning.java8.list_collect;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.javalearning.java8.data.DataSource;
import com.javalearning.java8.data.Developer;

public class MainDemo_List_to_Map {

	public static void main(String[] args) {
		
		List<Developer> devs = DataSource.getDevelopers();
		
		//name - developer
		Map<String, Developer> map1 = devs.stream()
										.collect(Collectors.toMap(Developer::getName, d -> d));
		map1.forEach((key, value) -> {
			System.out.println("Key: " + key + " - value: " + value);
		});
		
		System.out.println("------------------");
		//name - age
		Map<String, Integer> map2 = devs.stream()
										.collect(Collectors.toMap(Developer::getName, d -> d.getAge()));
		map2.forEach((key, value) -> {
			System.out.println("Key: " + key + " - value: " + value);
		});

	}

}
