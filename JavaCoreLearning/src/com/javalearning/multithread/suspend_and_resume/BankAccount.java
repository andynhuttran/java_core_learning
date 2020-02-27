package com.javalearning.multithread.suspend_and_resume;

public class BankAccount {
	
	private int balance;
	private String name;
	
	private int sub_balance;
	
	public BankAccount(String name, int balance){
		this.name = name;
		this.balance = balance;
		sub_balance = 0;
	}
	
	
	public synchronized void withdraw(int amount){
		
		System.out.println(this.name + " - processing to withdraw... |" + amount);
		
		if (this.balance < amount){
			System.out.println(this.name + " - balance is not enough for withdrawing");
			Thread.currentThread().suspend(); //stop this thread
		}
		
		if (sub_balance > 0){
			this.balance += this.sub_balance;			
			this.sub_balance = 0;
			
			System.out.println("********add balance from sub_balance: |" + this.balance + "|********");
		}
		
		this.balance -= amount;
		System.out.println(this.name + " - finish withdraw... |" + this.balance);
	}
	
	public synchronized void deposit(int amount){
		System.out.println(this.name + " - processing to deposit... |" + amount);
		this.balance += amount;
		System.out.println(this.name + " - finish deposit... |" + this.balance);
	}
	
	public void depositsubBalance(int amount){
		System.out.println(this.name + " - processing to depositsubBalance... |" + amount);
		this.sub_balance += amount;
		System.out.println(this.name + " - finish depositsubBalance... |" + this.sub_balance);
	}
	
	
	
}





