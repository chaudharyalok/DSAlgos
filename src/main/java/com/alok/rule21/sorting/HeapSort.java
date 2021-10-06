package com.alok.rule21.sorting;

public class HeapSort {

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
		
		// build heap (rearrange array)
		for(int i = n/2 -1; i>=0; i--)
			heapify(arr, n, i);
		
		// one by one extract an element from heap
		for(int i =n-1;i>0; i--){
			// move current root to end
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			
			// call max heapify on reduced heap
			heapify(arr, i, 0);
		}
	}
	
	private static void heapify(int[] arr, int n, int i){
		
		int l = i*2+1;
		int r = i*2+2;
		
		int largest = i;
		if(l<n && arr[largest]<arr[l])
			largest = l;
		if(r<n && arr[largest]<arr[r])
			largest = r;
		
		// if largest i not root
		if(largest != i){
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;
					
			heapify(arr, n, largest);
		}
		
	}

}
