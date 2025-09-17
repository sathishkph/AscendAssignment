package LinkedListAlgo;

public class DoubleLinkedList {

	Node head;
	
	
	
	class Node{
		
		Node prev;
		int val;
		Node next;
		Node(int val){
			this.prev=null;
			this.next = null;
			this.val = val;
			
		}
		
		
	}
	
	public DoubleLinkedList() {
		
	}
	
	public void add(int val) {
	      
		Node newNode = new Node(val);
		if (head == null) {
			head =newNode;
			return;
		}
		
		newNode.prev  = head.next;
		
		
		
		
		
		
	}

}
