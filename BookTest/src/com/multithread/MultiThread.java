package com.multithread;

import java.util.Comparator;
import java.util.function.Consumer;

public class MultiThread   {

	public static void main(String[] args) {
		
		Runnable r = () -> {
			System.out.println("i am child thread");
		};		
		
		//Runnable r1 = System::println;
	
		Thread a = new Thread(r);
		a.start();
		
		int c = 5;
		int b = 7;
		
		
		Consumer<String> a1 = String::length;
		
		
		
		System.out.println(a1.accept("walmart"););
		

	}

	
}
