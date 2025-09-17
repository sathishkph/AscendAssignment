package com.student;

import java.util.ArrayList;
import java.util.List;

public class ListDuplicate extends ArrayList {
	


	public static void main(String[] args) {
    ListDuplicate s1 = new ListDuplicate();
    
		
		
		s1.add("hi");
		s1.add("hi");
		s1.add("sathish");
		System.out.println(s1);
		

	}

	@Override
	public boolean add(Object o) {
		System.out.println("method is getting override");
		if (this.contains(o)) { return true;}
		else {	
		return super.add(o);}
	}

}
