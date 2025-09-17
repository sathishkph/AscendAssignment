package BinarySearchAlgo;

public class BestBuyandSell {

	public static void main(String[] args) {
		
		int [] a = {7, 1, 5, 3, 6, 4};
		 System.out.println(bookhighestProfit(a));

	}

	private static int bookhighestProfit(int[] a) {
		
		
		int max = 0;
		int n = a.length;
		for (int i = 0;i<n-1;i++) {
			for(int j=i+1;j<n;j++) {
				max = Math.max(max,(a[j] - a[i]));
								
			}
		}
		
		return max;
	}

}
