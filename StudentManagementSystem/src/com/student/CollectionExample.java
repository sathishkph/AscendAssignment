package com.student;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.student.*;

public class CollectionExample implements InvocationHandler   {
	
	

	public static void main(String[] args) {
		List<Student> s1 = new ArrayList<>();
		s1.add(new Student(1,"sathish",90.0));
		s1.add(new Student(1,"aakasha",100.0));
		s1.add(new Student(3,"sas",100.0));
		s1.add(new Student(2,"komal",100.0));
		List<Student> s2 = new ArrayList<>();
		s2.add(new Student(1,"sathish",90.0));
		System.out.println(s1);
		//System.out.println(s1.equals(s2));
		
		
		
		//System.out.println(s1);
		
		
		
		Runnable r = new Runnable () {
			public void run () {}
		};
		
		Runnable r1 = ()-> {int a = 5; };
		new Thread(r1).start();
		
		

	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		return null;
	}


}
