package com.javalearning.java8.use_lamda;

import com.javalearning.java8.data.Developer;

public class UseInterface {
	
	int value;
	
	public UseInterface(MyInterface c, Developer dev){
		value = c.myMethod(dev);
	}
	
	public void printResult(){
		System.out.println("value: " + value);
	}
	
}
