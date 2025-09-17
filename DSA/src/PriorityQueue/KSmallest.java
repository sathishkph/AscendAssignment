package PriorityQueue;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KSmallest {

	public static void main(String[] args) {
		
		int [] a = {3,1,6,4,5};
		
		System.out.println("after sort" + Arrays.toString(sort(a)));
		System.out.println("3rd Smallest Element   :" + findSmallest(a,3));
		
		System.out.println("3rd Smallest Element using heap  :" + findSmallestusingminHeap(a,3));
	}

	private static int[] sort(int[] a) {
		
		return a;
		
		
	}

	private static int findSmallest(int[] a, int k) {
		
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((b,c) ->{return (b -c);});
		
		for ( int j :a) {  //6,5,4,3,
			maxHeap.offer(j);// 3,1,6 ,4
			if (maxHeap.size() > k )
				maxHeap.poll();
			
		}
		
		return maxHeap.peek();
		
	}
	
private static int findSmallestusingminHeap(int[] a, int k) {
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<>((b,c) ->{return (b -c);});
		
		for ( int j :a) {  //6,5,4,3,
			minHeap.offer(j);// 3,1,6 ,4
			if (minHeap.size() > k )
				minHeap.poll();
			
			
		}
		
		return minHeap.peek();
		
	}

}
