package com.student;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;



public class PyramidPattern1 {

	public static void printStart(int rows) {

		for (int i = 1; i <= rows; i++) {

			int whitespaces = rows - i;

			print(" ", whitespaces);
			print(i + " ", i);
			System.out.println("");
			

		}
	}

	public static void print(String x, int y) {

		for (int i = 0; i < y ; i++) {

			System.out.print(x);

		}
		
		

	}

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int rows = sc.nextInt();
//		System.out.println("Printing Pyramid for rows" + rows);
		//printStart(rows);
		
		Integer [] arr = { 1,2,7,3,4,5};
		List<Integer> list = Arrays.asList(arr);
		System.out.println(list.stream().reduce((x,y) -> x + y ));
		
		System.out.println(list.stream().max((x,y)-> Integer.compare(x, y)));
		
		Random r = new Random();
		for (int i = 0;i < arr.length;i++) {
			int randomswap = r.nextInt(arr.length);
			System.out.println(randomswap);
			int temp = arr[randomswap];
			arr[randomswap] = arr[i];
			arr[i] = temp;
			
		}
		System.out.println(Arrays.toString(arr));
		
	}

}
