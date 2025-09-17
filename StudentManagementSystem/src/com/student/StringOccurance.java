package com.student;

import java.util.HashMap;
import java.util.Map;

public class StringOccurance {

	public static void main(String[] args) {
		
		String s = "sathishaaa";
		
		String s1 = s;
		
		System.out.println(s1 == s);
		
		 s = "java";
		 
		 System.out.println(s1 == s);
		 
		 System.out.println(s1);
		 
		 int a = 5;
		  int b =a;
		  System.out.println(a == b);
		  
		  a = 6;
		  
		  System.out.println(a == b);
		  System.out.println(	b);
		 
		 
		
		
		char[] ch = s.toCharArray();
		
		Map<Character,Integer> stringOccur = new HashMap<>();
		
		int value = 1;
		for(Character c: ch  ) {
			
			if (stringOccur.containsKey(c)) {
				
				 value = stringOccur.get(c);
				value++;
				
			}
			
				stringOccur.put(c, value);
			
		}
		
		System.out.println(stringOccur);
		
	}

}
