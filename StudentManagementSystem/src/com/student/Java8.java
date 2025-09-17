package com.student;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Java8 {

	public static void main(String[] args) {
		
		List<Integer> list =Arrays.asList(1,2,3,4,5,6,7,8,1,2,3,4,1,1);
		
		  Map<Integer, Long> s1 = list.stream().collect(Collectors.groupingBy( Function.identity(),Collectors.counting()));
		
		  System.out.println(s1);
		  
		List<Integer> f = list.stream().filter(t -> t > 3).toList();
		
		System.out.println(f);
		
		
		Function<Integer,String > function = t -> "hi" + t;
		
		
		
		System.out.println(function.apply(8));
		
		long  f1 =   list.stream().count();
		
		System.out.println(f1);
		
		List<Employee> employees = Arrays.asList(new Employee(101,"ECE",10000,Arrays.asList("sat@gamil.com","Hi@gmail.com"))
				,new Employee(102,"IT",20000,Arrays.asList("sat1@gamil.com","Hi1@gmail.com"))
				,new Employee(103,"Mech",30000,Arrays.asList("sat2@gamil.com","Hi2@gmail.com"))
				,new Employee(104,"CSE",40000,Arrays.asList("sat3@gamil.com","Hi3@gmail.com"))
				,new Employee(105,"IT",30000,Arrays.asList("sat4@gamil.com","Hi4@gmail.com"))
				,new Employee(106,"IT",50000,Arrays.asList("sat5@gamil.com","Hi5@gmail.com"))			
				);
 List<Integer> ids = employees.stream().map((e)-> e.getId()).toList();
 
 List<List<String>> emails =  employees.stream().map((e)-> e.getEmail()).toList();
 
 System.out.println(emails);
 
 
 List<String> emailids =  employees.stream().flatMap(t -> t.getEmail().stream()).collect(Collectors.toList());
		
 System.out.println(emailids);
 
employees.stream().forEach(t -> System.out.println(t.getId()));

 Object s = Comparator.comparingLong(Employee::getSalary);
 
 



  employees.stream().collect(Collectors
		  .groupingBy(Employee::getDept,Collectors.toList()));

//System.out.println(groupandsort);

  
  Map<String, Optional<Employee>> groupedAndSorted = employees.stream()
          .collect(Collectors.groupingBy(Employee::getDept,
                  Collectors.reducing(BinaryOperator.maxBy(Comparator.comparing(Employee::getSalary)))));
  
  System.out.println(groupedAndSorted);
  
  
  System.out.println("reducing " +   employees.stream()  
  .reduce(BinaryOperator.maxBy(Comparator.comparing(Employee::getSalary)))
  .map(t ->  t.getEmail() + t.getDept() 
	  ));
 
  
  System.out.println("Sorting  " +   employees.stream()  
  .collect(Collectors.groupingBy(Employee::getDept,Collectors.collectingAndThen
		  ( Collectors.toList() ,lists -> 
		  { 
		lists.sort(Comparator.comparingInt(Employee::getId));
		  
		  return list;
		  }
		  
				  )))
	);
 
 
	}

}
