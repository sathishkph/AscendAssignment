package com.emp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.*;
//import java.util.stream.IntStream;

public class EmpTest {

	public static void main(String[] args) {
		List<emp> l = new ArrayList<>();
		l.add(new emp(10,"ann",6000.0));
		l.add(new emp(20,"znn",7000.0));
		l.add(new emp(30,"tnn",8000.0));
		l.add(new emp(40,"bnn",9000.0));
		
		
		l.stream().sorted(Comparator.comparing(emp::getName)).forEach(System.out::println);
		
		
		l.stream().sorted(
			
			(o1,o2) -> {
				return (int) ( o1.getName().compareTo(o2.getName()));
						});
		
		
		int [] arr = new int[]{1,2,4,5,6};
		IntStream s = Arrays.stream(arr);
		System.out.println("sum    " + Arrays.stream(arr).reduce((x,y) -> (x +y)).getAsInt());
		
		
			
		
		/*
		 * l.stream().sorted(new Comparable() {
		 * 
		 * public int compareTo(emp o1,emp o2) { return }
		 * 
		 * } )
		 */
		

	}

}
