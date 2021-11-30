package com.alok.rule21.arrays;

import java.util.Arrays;

public class MergeSorted {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3,4,5,7,9};
		int[] arr2 = {1,6,8};
		
		merge2(arr, arr2);
		printArray(arr);
		System.out.println();
		printArray(arr2);

	}
	
	private static void printArray(int[] arr){
		for(int a: arr)
		System.out.print(a+" ");
	}
	
	private static void merge(int[] arr, int[] arr2){
		
		int n = arr.length;
		int m = arr2.length;
		
		for(int i = m-1 ; i>=0 ; i--){
			
			int j, last = arr[n-1];
			for(j= n-2;j>=0 && arr[j]>arr2[i];j--){
				arr[j+1] = arr[j];
			}
			
			if(j != n-2 || last> arr2[i]){
				arr[j+1] = arr2[i];
				arr2[i] = last;
			}
		}
	}
	
	private static void merge2(int[] arr, int[] arr2){
		
		int i =0;
		int n = arr.length;
		while(arr[n-1]> arr2[0]){
			
			if(arr[i]>arr2[0]){
				int temp = arr[i];
				arr[i] = arr2[0];
				arr2[0] = temp;
				
				Arrays.sort(arr2);
			}
			i++;
		}
	}

}
