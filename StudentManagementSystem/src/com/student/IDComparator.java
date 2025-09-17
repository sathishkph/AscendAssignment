package com.student;

import java.util.Comparator;

public class IDComparator implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		if (o1.getStudentID() == o2.getStudentID()) { 
			
			return o1.getName().compareTo(o2.getName());
		}
		else if (o1.getStudentID() > o2.getStudentID()) { return 1;}
		else { return -1;}
		
	}

}
