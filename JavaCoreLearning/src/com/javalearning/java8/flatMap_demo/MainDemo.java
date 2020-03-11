package com.javalearning.java8.flatMap_demo;

import java.util.Arrays;
import java.util.stream.Stream;

public class MainDemo {

	public static void main(String[] args) {
		
		//init array
		String[][] data = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};

        //build to stream level 1		
        Stream<String[]> stream1 = Arrays.stream(data);
        
        /*
        System.out.println("Stream 1");
        stream1.forEach(arr -> {
        	for (String str : arr){
        		System.out.println(str);
        	}
        	System.out.println("----");
        });
        */
        
        
        //build to stream level flat        
        Stream<String> stream2 = stream1.flatMap(s -> Arrays.stream(s));
        
        System.out.println("Stream 2");
        stream2.forEach(str -> {
        	System.out.println(str);
        });
        
	}

}
