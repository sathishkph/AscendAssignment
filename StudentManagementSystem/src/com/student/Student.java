package com.student;

import java.util.Comparator;
import java.util.Objects;

public class Student  {
	

	public Student(int studentID, String name, double score) {
		super();
		this.studentID = studentID;
		this.name = name;
		this.score = score;
	}
	private int studentID;
	private String name;
	private double score;
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "Student [studentID=" + studentID + ", name=" + name + ", score=" + score + "]";
	}
	
	/*
	 * @Override public int hashCode() { return Objects.hash(name, score,
	 * studentID); }
	 */
	
	
	/*
	 * @Override public boolean equals(Object obj) { if (this == obj) return true;
	 * if (obj == null) return false; if (getClass() != obj.getClass()) return
	 * false; Student other = (Student) obj; return Objects.equals(name, other.name)
	 * && Double.doubleToLongBits(score) == Double.doubleToLongBits(other.score) &&
	 * studentID == other.studentID; }
	 */
	/*
	 * @Override public int compareTo(Student o) { if (this.studentID ==
	 * o.studentID) { return 0;} else if (this.studentID > o.studentID) { return
	 * -1;} else { return 1;}
	 * 
	 * 
	 * }
	 */
	
	
	

}
