package BinarySearchAlgo;

import java.math.BigDecimal;

public class Factorial {

	public static void main(String[] args) {
		factorialLargnum(100);
	}

	private static void factorialLargnum(int n) {
		
		BigDecimal b = new BigDecimal(1);
		for (int i = 2; i <=n; i++) {
		   b.multiply(BigDecimal.valueOf(i));	
		}
		
	}

}

//  1 2 3 4 5 
1
5
4

4 -1 = 3

4 - 2 = 2
 
4 - 3 = 1
 
4-4 = 0;
4-5 = 0
