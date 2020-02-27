package com.javalearning.multithread.wait_and_notifyall;

public class BankAccount {
	
	private int balance;
	private String name;
	
	public BankAccount(String name, int balance){
		this.name = name;
		this.balance = balance;
	}
	
	
	public synchronized void withdraw(int amount){
		
		System.out.println(this.name + " - processing to withdraw... |" + amount);
		
		if (this.balance < amount){
			System.out.println(this.name + " - balance is not enough for withdrawing");
			
			try {
				wait(); //wait for others thread to deposit
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}
		
		this.balance -= amount;		
		System.out.println(this.name + " - finish withdraw... |" + this.balance);
	}
	
	public synchronized void deposit(int amount){
		
		System.out.println(this.name + " - processing to deposit... |" + amount);
		this.balance += amount;
		System.out.println(this.name + " - finish deposit... |" + this.balance);
		
		if (this.name.indexOf("2") >= 0 ){
			notifyAll(); //notify all threads waitingi
		}
		else {
			notify(); //notify a random thread waiting
		}
	}
	
	
}





