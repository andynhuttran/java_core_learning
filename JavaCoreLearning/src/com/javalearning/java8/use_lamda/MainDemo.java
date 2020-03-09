package com.javalearning.java8.use_lamda;

import com.javalearning.java8.data.Developer;

public class MainDemo {

	public static void main(String[] args) {
		Developer dev = new Developer("Cole", 32, 1500);
		
		MyInterface c = (Developer d) -> d.getAge(); //return age
		UseInterface userC1 = new UseInterface(c, dev);
		userC1.printResult();
		
		UseInterface userC2 = new UseInterface(d -> d.getSalary(), dev); //return salary
		userC2.printResult();
	}
	
}
