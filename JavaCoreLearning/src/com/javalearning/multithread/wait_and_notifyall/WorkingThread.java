package com.javalearning.multithread.wait_and_notifyall;

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
