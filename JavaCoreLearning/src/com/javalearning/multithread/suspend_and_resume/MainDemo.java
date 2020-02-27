package com.javalearning.multithread.suspend_and_resume;

public class MainDemo {
	
	public static void main(String[] args) {
		
		System.out.println("---Start main thread");
		
		BankAccount account1 = new BankAccount("Account 1", 1000);		
		WorkingThread withdrawThread1 = new WorkingThread(account1, 2000, true);
		withdrawThread1.start();
		
		
		Thread t1 = new Thread(new Runnable() {				
			@Override
			public void run() {
				try {
					Thread.sleep(5000);
					account1.depositsubBalance(5000);
					
					System.out.println(withdrawThread1.getState());					
					withdrawThread1.resume(); //start this thread again to continue withdraw
					
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			}
		});			
		t1.start();
			


		System.out.println("---End main thread");
		
	}
}
