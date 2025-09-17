package LinkedListAlgo;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ReverseList {
	
	
	static void reverseList(List<Integer> l) {
		
		
		Collections.reverse(l);
		
		
		
		
	}

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>(); 
		
		list.add(5);
		list.add(3);
		list.add(4);
		list.add(9);
		
		System.out.println(list);
		
		reverseList(list);
		
		System.out.println(list);
		
		
		
		
		
		

	}

}
