package com.student;

import java.util.HashSet;
import java.util.Set;

public class SetObject {
	
	

	public static void main(String[] args) {
		
		Set<Student> s1 = new HashSet<>();
		s1.add(new Student(101,"sathish",100));
		s1.add(new Student(101,"sathish",100));
		s1.add(new Student(101,"sathish",100));
		System.out.println(s1);
		

	}

}
