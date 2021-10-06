package com.alok.rule21.sorting;

public class SelectionSort {

	/**
	 * in place
	 * time complexity of O(n^2)
	 * The good thing about selection sort is 
	 * it never makes more than O(n) swaps and 
	 * can be useful when memory write is a costly operation.
	 * 
	 */
	public static void main(String[] args) {

		int[] arr = { 5, 1, 9, 3, 0, 6 };
		sort(arr);
		printArray(arr);
	}
	
	private static void printArray(int[] arr) {
		for (int a : arr) {
			System.out.print(a + " ");
		}
	}
	
	private static void sort(int[] arr){
	
		int n = arr.length;
		for(int i=0; i<n-1; i++){
			
			int min_index = i;
			for(int j=i+1; j<n; j++){
				if(arr[j] < arr[min_index] ){
					min_index = j;
				}
			}
			// swap element at i & min_index
			int temp = arr[min_index];
			arr[min_index] = arr[i];
			arr[i] = temp;
		}
	}

}
