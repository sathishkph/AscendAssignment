package com.student;

import java.util.List;

public class Employee {
	
	
	
	public Employee(int id, String dept, long salary, List<String> email) {
		super();
		this.id = id;
		this.dept = dept;
		this.salary = salary;
		this.email = email;
	}
	private int id;
	private String dept;
	private long salary;
	
	private List<String> email;
	public int getId() {
		this.dept.
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	public List<String> getEmail() {
		return email;
	}
	public void setEmail(List<String> email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", dept=" + dept + ", salary=" + salary + ", email=" + email + "]";
	}

}
