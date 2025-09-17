package BinarySearchAlgo;

import java.util.Arrays;
import java.util.List;

public class ProductArray {
	
	
	public static int [] getProduct(int[] a) {
		
		int l = a.length;
		int [] prod = new int[l];
		
		int temp =1;
		
		//;lft side ..
		for(int i = 0; i < l; i++) {
			
			prod[i] = temp;
			temp *= a[i];
			
			
		}
		temp =1;
		
		for (int j = l -1;j>=0;j-- ) {
			
			prod[j] *= temp;
			temp *= a[j];
			
		}
		
		
		return prod;
	}

	public static int productSubArray(int[] a) {
		
		
		int max_product_so_far = Integer.MIN_VALUE;
		int max_array_ending = 1;
		for (int i = 0;i<a.length;i++) {
			
			max_array_ending = max_array_ending * a[i];
			
			if (max_product_so_far < max_array_ending ) {
				max_product_so_far  = max_array_ending;
			}
			
			
			
			
		}
		
		
		return max_product_so_far;
		
		
	}
	
	
	public static void main(String[] args) {
		int[] a = { 2,3,4,5,6};
		
		//System.out.println(Arrays.toString(a));
		
		 // List<int[]> b = Arrays.asList(getProduct(a));
		//System.out.println(Arrays.toString(getProduct(a)));
		
		int[] b = {-1, -3, -10, 0, 60};
		
		System.out.println(productSubArray(b));
		

	}

}

///Largest Sub array


