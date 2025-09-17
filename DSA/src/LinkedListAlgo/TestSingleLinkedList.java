package LinkedListAlgo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class TestSingleLinkedList {
	
	
	static  void reverse(SingleLinkedList list) {
		SingleLinkedList reverse = new SingleLinkedList();
		
		
		
		for (int i = 0; i < list.getSize();i++) {
			
			
			
			
		}
		
		
	}

	public static void main(String[] args) {
		SingleLinkedList list = new SingleLinkedList();
		
		SingleLinkedList list1 = new SingleLinkedList();
		list1.add(1);
		list1.add(3);
		list1.add(6);
		list1.add(7);
		
		list.add(9);
		list.add(4);
		list.add(2);
		list.add(5);
		//list.add(0,1);
	//	list.add(5,7);
		
	//	list.printList();
	//	System.out.println("size" + list.getSize());
//		list.delete(1);
		//System.out.println("size after" + list.getSize());
		list.printList();
		System.out.println("size rever");
		list.reverse();
		list.printList();
		System.out.println("size rever ending");
		
		
		
	list.printList();
	//System.out.println("search");
	//System.out.println(list.get(0));
	
	List<Integer> merge = new ArrayList<>();
	
	while(list.head  != null) {
	   merge.add(list.head.value);
	   
	   list.head = list.head.next; 
	   		
	}
	while(list1.head  != null) {
		   merge.add(list1.head.value);
		   
		   list1.head = list1.head.next; 
		   		
		}
	
	System.out.println(merge.toString());
	
	Collections.sort(merge);
	
	System.out.println(merge.toString());
	
	
	
	

	}

}
