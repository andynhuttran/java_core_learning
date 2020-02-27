package com.javalearning.multithread.wait_and_notifyall;

public class MainDemo {
	
	public static void main(String[] args) {
		BankAccount account1 = new BankAccount("Account 1", 1000);		
		WorkingThread withdrawThread1 = new WorkingThread(account1, 2000, true);
		withdrawThread1.start();
		
		WorkingThread withdrawThread2 = new WorkingThread(account1, 3000, true);
		withdrawThread2.start();
		
		try {
			System.out.println("Start deposit thread");
			WorkingThread depositThread = new WorkingThread(account1, 7000, false);
			depositThread.start();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		BankAccount account2 = new BankAccount("Account 2", 400);		
		WorkingThread withdrawThread3 = new WorkingThread(account2, 500, true);
		withdrawThread3.start();
		
		WorkingThread withdrawThread4 = new WorkingThread(account2, 500, true);
		withdrawThread4.start();
		
		try {
			System.out.println("Start deposit thread");
			WorkingThread depositThread = new WorkingThread(account2, 7000, false);
			depositThread.start();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
