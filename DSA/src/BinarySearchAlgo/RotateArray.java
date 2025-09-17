package BinarySearchAlgo;

import java.util.Arrays;

public class RotateArray {
	
	

	public static void main(String[] args) {
		int[] a = {1,2,3,4,5};
		int n = 4;
		int [] b = rotate(a,n);
		
		System.out.println(Arrays.toString(b));

	}

	private static int [] rotate(int[] a,int k) {
		
		int n = a.length;
		
		int b [] = new int[a.length];
		int i= 0;
		while(i <k) {
			
			System.out.println("a before =======" + Arrays.toString(a));
			for (int j = 0;j< n-1;j++) {
				b[j]=a[j+1];
				
			}
			System.out.println("b =======" + Arrays.toString(b));
			
			System.out.println("a =======" + Arrays.toString(a));
			b[n-1] = a[0];
			System.out.println("b after =======" + Arrays.toString(b));
		for (int x = 0;x < n;x++) {
			a[x]=b[x];
		}
			  
			i++;
			System.out.println(Arrays.toString(b));
			
		}
		
		return b;
		
	}

}
