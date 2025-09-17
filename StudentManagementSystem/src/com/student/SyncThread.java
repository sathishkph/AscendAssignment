package com.student;

public class SyncThread implements Runnable {

	
	 Object obj1 = new Object();
	  Object obj2 = new Object();
	  
	  public SyncThread(Object ob1,Object ob2) {
		  this.obj1 = ob1;
		  this.obj2 = ob2;
	  }
	  public void run() {
	        String name = Thread.currentThread().getName();
	        System.out.println(name + " acquiring lock on obj1  "+obj1);
	        synchronized (obj1) {
	         System.out.println(name + " acquired lock on obj1"+obj1);
	         work();
	         System.out.println(name + " acquiring lock on obj2"+obj2);
	         synchronized (obj2) {
	            System.out.println(name + " acquired lock on obj2"+obj2);
	            work();
	        }
	         System.out.println(name + " released lock on obj2 "+obj2);
	        }
	        System.out.println(name + " released lock on obj1 "+obj1);
	        System.out.println(name + " finished execution.");
	    }
	
	
	public void work() {
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	  
	  
}
