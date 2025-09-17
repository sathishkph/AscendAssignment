package BinarySearchAlgo;

import java.util.Arrays;
import java.util.HashSet;

public class BinarySearch {
	
	// middle ele
	
	//0 1 2 3 4 5 6 
	
	//6 > 3 
	
	//    [1, 2, 3, 5, 6, 8, 9, 10, 11]     4   sum > 4 --> 
	
	public static int[] checkTwoSum(int[] a,int s) {
		
		int [] f = new int[2];
		
		int l = 0;
		int h = a.length -1 ;
		
		while (l <= h) {
			System.out.println("l   :" + l + "h    : " + h );
			int sum = a[l] + a[h];
			
			if (sum == s) {
				f[0] = l;
				f[1] = h;
				return f;
			}
			else if (sum > s) {
				h--;
				
			}
			else {
				l++;
			}
		}
		
		return f;
		
	}
	
	
	public static  int findElement(int[] a, int s) {
		
		int l = 0;
		int h =  a.length - 1;
		 
		while (l <= h) {
			
			int m = (l + h) / 2;
			
			if (a[m] == s) {
			return m;	
			}else if (a[m] > s) {
				
				h = m-1;
			}
			else {
				l = m +1;
			}
			
		}
		
		
		return -1;
	}
	
	
public static  int findElementRecurssive(int[] a, int s) {
		
		int l = 0;
		int h =  a.length - 1;
		 
		while (l <= h) {
			
			int m = (l + h) / 2;
			
			if (a[m] == s) {
			return m;	
			}else if (a[m] > s) {
				
				h = m-1;
			}
			else {
				l = m +1;
			}
			
		}
		
		
		return -1;
	}

public static boolean findSumElementUsingHashing(int [] a,int s) {
	int temp = 0;
	HashSet<Integer> h = new HashSet<>();
	for (int i = 0; i < a.length;i++ ) {
		 temp = s - a[i];
		 
		 if (h.contains(temp)) {
			return true;
		 }
		 
		 h.add(a[0]);
		
		
	}
	
	
	
	return false;
}

public static int findRotatedSearch(int [] b,int j) {
	int a=0;
	int low = 0;
	int high = b.length;
	int min =0;
	while(low <= high ) {
		
		int mid = (low + high) / 2;
		
		if (b[mid]< b[mid-1]) {
			 min = b[mid];}
		else if ( b[mid] > b[mid -1]) {
			low = mid +1;
		}
		else {
			high = mid -1;
			
			
		}
		
		
	}
	
	
	return min;
	
}



	public static void main(String[] args) {
		int[] A = {1,5,8,11,9,3,6,10,2};
		Arrays.sort(A);
		System.out.println(Arrays.toString(A));
		int i = 99;
		  //System.out.println(findElement(A,i));
		//  System.out.println(Arrays.toString(checkTwoSum(A,i)));
		  
		//  System.out.println(findSumElementUsingHashing(A,i));
		
		int[] b = {30, 40, 50, 10, 20};
		int j = 10;
		
		 System.out.println(findRotatedSearch(b,j));
	}

}
