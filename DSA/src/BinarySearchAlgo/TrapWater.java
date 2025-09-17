package BinarySearchAlgo;

public class TrapWater {
	

    // Function to return the maximum 
    // water that can be stored 
    public static int maxWater(int[] arr, int n) 
    { 
  
        // To store the maximum water 
        // that can be stored 
        int res = 0; 
  
        // For every element of the array 
        // except first and last element 
        for (int i = 1; i < n - 1; i++) { 
  
            // Find maximum element on its left 
            int left = arr[i]; //2,
            for (int j = 0; j < i; j++) { 
                left = Math.max(left, arr[j]); //2,3
            } 
  
            // Find maximum element on its right 
            int right = arr[i];  //1 
            for (int j = i + 1; j < n; j++) { 
                right = Math.max(right, arr[j]);  //3
            } 
  
            // Update maximum water value 
            res += Math.min(left, right) - arr[i]; //2-2= 0
        } 
        return res; 
    } 
  
    // Driver code 
    public static void main(String[] args) 
    { 
        int[] arr = { 1,2,3,4,5 }; 
        int n = arr.length; 
  
        System.out.print(maxWater(arr, n)); 
    } 
    
    
    
    
    //nput: string = “geeksforgeeks”, pattern = “ork” 
   // Output: “ksfor”
    
    /*  if matches || count >0
     * count=1
     * 
     * 
     */
     */
} 
