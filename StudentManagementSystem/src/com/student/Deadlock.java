package com.student;

public class Deadlock  {
	
	
	 

	public static void main(String[] args) {
		
		Object o1 = new Object();
		Object o2 = new Object();
		Object o3 = new Object();
		
		Thread t1 = new Thread(new SyncThreadwait(o1,o2),"t1");
		Thread t2 = new Thread(new SyncThreadwait(o2,o3),"t2");
		Thread t3 = new Thread(new SyncThreadwait(o3,o1),"t3");
		t1.start();
		t2.start();
		t3.start();

	}

	
}
