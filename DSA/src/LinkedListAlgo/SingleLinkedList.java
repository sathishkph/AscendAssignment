package LinkedListAlgo;

import java.util.Collections;

public class SingleLinkedList {

	Node head;
	Node node;

	class Node {
		int value;
		Node next;

		Node(int value) {
			this.value = value;
			next = null;
		}
	}

	public SingleLinkedList() {
		this.head = null;

	}

	public void add(int value) {
		Node newNode = new Node(value);
		if (head == null) {
			head = newNode;
		} else {
			Node temp = head;

			while (temp.next != null) {
				temp = temp.next;

			}
			temp.next = newNode;

		}
	}

	public void add(int pos, int value) {
		Node newNode = new Node(value);

		if (pos == 0) {
			newNode.next = head;
			head = newNode;

		} else {
			Node temp = head;

			for (int i = 1; i < pos; i++) {
				temp = temp.next;
			}
			
			

			newNode.next = temp.next;

			temp.next = newNode;
		}
		
		

	}
	
	
	public void delete(int pos) {
		Node temp = head;

		if (pos == 0) {
			
			 head.next = null;
			head = temp.next;
			

		} else {
			

			for (int i = 1; i < pos; i++) {
				temp = temp.next;
			}
			
			
         temp.next = temp.next.next;
			
		}
		
		
		
		

	}

	public void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.value + " ");
			temp = temp.next;
		}

	}

	public int get(int n) {

		Node temp = head;

		for (int i = 0; i < n; i++) {
			temp = temp.next;

		}
		return temp.value;

	}
	
	public int getSize() {
		
		Node temp = head;
		if (head == null) {
			return 0;
		}
		int i=1;
		
		while(temp.next !=null) {
			i++;
			temp = temp.next;
		}
		
		return i;
	}
	
	public void reverse(){
		
		//SingleLinkedList a = new SingleLinkedList();
		
		Node prev = null;
		Node curr = head;
		Node Next = head.next;
		//System.out.println("head value" + head.value);
		
		while( curr != null) {
			
	         Next = curr.next;
	       
	       curr.next = prev;
	         
	         prev = curr;
	         curr = Next;
	         System.out.println("loop1");
			
		}
		head = prev;
		
		 
		//System.out.println("head value" + head.value);
	}
	
	
	 

}
