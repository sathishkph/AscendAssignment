package com.student;

public class EvenAndOdd implements Runnable {
	
	
	static int i = 1;
	  Object lockObject = new Object();
	
	
//	private EvenAndOdd (Object lockObject) {
//		
//		this.lockObject = lockObject;
//	}
	
	
	public void run () {
		while(i <= 10) {
		if ((i%2== 0) && Thread.currentThread().getName().equals("EVEN")) {
			
			synchronized (lockObject) {
				
				System.out.println(Thread.currentThread().getName() + " " + i);
				i++;		
				try {
					//lockObject.wait();
					Thread.sleep(100000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
		}
		}
		
		if ((i%2 != 0) && Thread.currentThread().getName().equals("ODD")) {
			
 synchronized (lockObject) {
				
				System.out.println(Thread.currentThread().getName() + " " + i);
				i++;		
				//lockObject.notify();
					
		}
			
		}
		}
		
	}
	

	


	public static void main(String[] args) {
		
		EvenAndOdd a = new EvenAndOdd();
		Thread t1 = new Thread(a);
		t1.setName("ODD");
		t1.start();
		
		Thread t = new Thread(a);
		t.setName("EVEN");
		t.start();
		
		

	}

}
