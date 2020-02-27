package com.javalearning.multithread.suspend_and_resume;

public class WorkingThread extends Thread {

	private BankAccount account;
	private int amount;
	private boolean withdraw;
	
	public WorkingThread(BankAccount account, int amount, boolean withdraw){
		this.account = account;
		this.amount = amount;
		this.withdraw = withdraw;
	}
	
	
	@Override
	public void run(){
		if (withdraw){
			account.withdraw(amount);
		}
		else {
			account.deposit(amount);
		}
		
	}
	
}
