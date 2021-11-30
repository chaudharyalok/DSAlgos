package com.alok.rule21.searching;

import java.util.Arrays;

public class BinarySearch {

	/**
	 * O(nlogn)
	 * time complexity of T(n) = T(n/2) + c 
	 * auxiliary space in recursive approach O(n)
	 * auxiliary space in iterative approach O(1)
	 */
	public static void main(String[] args) {

		int[] arr = { 5, 1, 9, 3, 0, 6 };
		Arrays.sort(arr);
		printArray(arr);
		System.out.println("Element found at:-> " +searchIterative(arr, 5,0,arr.length-1));
	}
	
	private static void printArray(int[] arr) {
		for (int a : arr) {
			System.out.print(a + " ");
		}
	}
	private static int search(int[] arr, int element, int low, int high){
		
		if(low<=high){
		int m = low+(high-low)/2;
		if(arr[m] == element)
		return m+1;
		 if(element < arr[m])
			return search(arr, element, low, m-1);
		 
			return search(arr, element, m+1, high);
		
		} 
		return -1;
	}
	
	private static int searchIterative(int[] arr, int element, int low, int high){
		
		while(low<=high){
			
			int m = low+(high-low)/2;
			if(arr[m] == element)
				return m+1;
			if(element < arr[m])
				high = m-1;
			else low = m+1;
		}
		return -1;
	}

}
