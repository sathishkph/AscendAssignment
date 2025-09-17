package BinarySearchAlgo;

public class ContiguosArray {
	
	public static int maxArray(int[] a) {
		
		int max_so_far = Integer.MIN_VALUE;
		int max_ending_here = 0;
		
		for(int i = 0; i <a.length;i++) {
			
			max_ending_here = max_ending_here + a[i];
			
			
			if ( max_so_far < max_ending_here ) {
				max_so_far = max_ending_here;
			}
			System.out.println("max_so_far" + max_so_far);
			
			  if (max_ending_here < 0)
				  max_ending_here = 0;
			 
        
		}
		
		return max_so_far;	
	}

	//-2 
	
	// -2 -5 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] a = {2, 3, 1, 1, 2, 1, 4, 3};
		
		System.out.println( maxArray(a));
		

	}

}
