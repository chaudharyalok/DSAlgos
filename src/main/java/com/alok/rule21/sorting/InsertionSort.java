package com.alok.rule21.sorting;

public class InsertionSort {

	/**
	 * in place sorting, does not require extra space
	 * time complexity of O(n^2)
	 * auxiliary space O(1)
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
		for(int i = 1;i<n;i++){
			
			int key = arr[i];
			int j = i-1;
			while(j>=0 && arr[j]>key){
				arr[j+1]= arr[j];
				j--;
			}
			arr[j+1] = key;
		}
	}
	
	

}
