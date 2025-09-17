package LinkedListAlgo;

import java.util.PriorityQueue;

public class PriorityQueueTest {

	public static void main(String[] args) {

		PriorityQueue<Integer> e = new  PriorityQueue<Integer>();
		e.add(5);
		e.add(6);
		e.add(8);
		e.add(7);
		e.add(0);

		
		
		System.out.println(e);
		
		System.out.println( "peek     " + e.peek() );
		System.out.println( "poll     " + e.poll() );
		System.out.println( "peek     " + e.peek() );
		System.out.println( "poll     " + e.poll() );
		System.out.println( "peek     " + e.peek() );
		System.out.println( "poll     " + e.poll() );
		System.out.println( "peek     " + e.peek() );
		
		System.out.println( "poll     " + e.poll() );
		System.out.println( "peek     " + e.peek() );
		System.out.println( "poll     " + e.poll() );
		System.out.println( "peek     " + e.peek() );
		System.out.println( "poll     " + e.poll() );
		System.out.println( "poll     " + e.poll() );

	}

}
