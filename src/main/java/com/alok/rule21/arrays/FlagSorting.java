package com.alok.rule21.arrays;

public class FlagSorting {

	public static void main(String[] args) {

		int[] arr = {1,0,0,0,0,1,0,0};
		sortBinary(arr);
		printArray(arr);
		
	}
	
	private static void swap(int[] arr, int i, int j){
		
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	private static void printArray(int[] arr){
		for(int a: arr)
		System.out.print(a+" ");
	}
	
	private static void sort(int[] arr){
		
		int left = 0;
		int right = arr.length;
		
		for(int i=0; i<right;i++){
			
			if(arr[i] == 0){
				swap(arr, i, left++);
			}
			
			if(arr[i] == 2){
				swap(arr, --right, i--);
			}
		}
	}
	
	private static void sort2(int[] arr){
			
			int left = 0;
			int right = arr.length-1;
			
			for(int i=0; i<=right;i++){
				
				if(arr[i] == 0){
					swap(arr, i, left++);
				}
				
				if(arr[i] == 2){
					swap(arr, right--, i--);
				}
			}
		}
		
	private static void sortBinary(int[] arr){
			
			int right = arr.length-1;
			
			for(int i=0; i<=right;i++){
				
				if(arr[i] == 1){
					swap(arr, right--, i--);
				}
			}
		}

}
