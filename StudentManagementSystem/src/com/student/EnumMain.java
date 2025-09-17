package com.student;

import java.io.IOException;
import java.util.HashSet;

public class EnumMain {

	public static void main(String[] args) {

		System.out.println(EnumExample.ORANGE);

		EnumExample[] eh1 = EnumExample.values();

		for (EnumExample eh : eh1) {
			System.out.println(eh);

		}

		System.out.println("weekday" + Weekday.FRIDAY.getDescription() + Weekday.FRIDAY.getNumericValue());

		String s1 = "abc";
		String s2 = "abc";

		System.out.println("s1 == s2 is:" + (s1 == s2));

		String s3 = "JournalDev";
		int start = 1;
		char end = 5;

		System.out.println(s3.substring(start, end));

		Integer k = 1;

		int t = 5;
		t = k;

		HashSet shortSet = new HashSet<>();
		int j;
		for (long i = 0; i < 10; i++) {
			shortSet.add(i);
			//j =  (i - 1l);

			System.out.println(shortSet.remove((i - 1)));
			System.out.println(shortSet);
		}

		System.out.println(shortSet.size());
		
		//*******************
		
		System.out.println("In Finally111111");
//		boolean flag = false;
//		try {
//			if (flag) {
//		  		while (true) {
//		   		}
//		   	} else {
//		   		System.exit(1);
//		   	}
//		} finally {
//		   	System.out.println("In Finally");
//		}
		
		String str = null;
		String str1="abc";

		//System.out.println(str1.equals("abc") | str.equals(null));
		
		
		String x = "abc";
		String y = new String("abc");
		String z = "abc";

		x.concat(y);

		System.out.println(x.hashCode());
		System.out.println(y.hashCode());
		System.out.println(z.hashCode());
		System.out.println("x == y" + (x == y));
		
		System.out.println("x == z" + (x == z));
		
            int c = 10 * 10 - 10;
   		
   		System.out.println(c);
   		
   		try {
   			throw new IOException("Hello");
   		} catch(  IOException  e) {
   			System.out.println(e.getMessage());
   		}

	}

}
