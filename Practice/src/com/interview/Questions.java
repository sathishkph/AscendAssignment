package com.interview;

import java.util.Arrays;
import java.util.List;

public class Questions {
	
	
//	Swap two number 
//	
//	X = X + Y;
//	Y = X -Y;
//	X = X -Y;
	
	
	/* Reverse a String 
	 *  String s = "sath"
	 * String s = "sath";
	    char[] chars = s.toCharArray();
	 * 
	 * prime number 
	 * 0 and 1 are not prime ,2 is prime start ,,in loop start with 2 ,condition of n/2 
	 * 
	 * fibonacci 
	 * 
	 * A Fibonacci sequence is one in which each number is the sum of the two previous numbers.
	 * a= 0;b = 1; c= 1;
	 * in loop print a ,move a= b,b = c,c = a+b untile given number.
	 * 
	 * list contain odd or not
	 * 
	 * remove whitespace in String 
	 * 
	 * Character.isWhitespace(c)  or s.Strip()..s is string here 
	 * 
	 */
	
	
	
	public static void main(String[] args) {
		
		String s = "sathish";
		s.toLowerCase().matches(".*[aeiou]*.*");
		
		List<Integer> a = Arrays.asList(1,3,5,7,9,11);
		List<Integer> b = Arrays.asList(1,3,5,7,8,11);
		
		List<Integer>  odd = a.stream().filter(i -> (i % 2) == 0).toList();
		
		System.out.println(a.stream().anyMatch(i -> (i % 2) ==0));
		if (odd.isEmpty()) {
			System.out.println("list contains even");
		}
		
		
		

	
	
}
	
}
