package com.javalearning.java8.forEach_Map_List;

import java.util.HashMap;
import java.util.Map;

import com.javalearning.java8.data.Developer;

public class MainDemo_Map {
	public static void main(String[] args) {
		
		Map<String, Developer> items = new HashMap<>();
		
		items.put("A", new Developer("Andy", 32, 1500));
		items.put("B", new Developer("Bob", 20, 1000));
		items.put("C", new Developer("Cole", 55, 1800));
		items.put("D", new Developer("David", 45, 2500));
		items.put("E", new Developer("Edward", 25, 3000));
		
		//before java 8
		System.out.println("--------------before java 8");
		for (Map.Entry<String, Developer> pair : items.entrySet()){
			System.out.println("Key: " + pair.getKey() + " - Value: " + pair.getValue());
		}
		
		
		//java8
		System.out.println("--------------java 8 - forEach");
		items.forEach((k, v) -> {
			//could add condition or process here
			System.out.println("Key: " + k + " - Value: " + v);
		});
		
		
	}
}








