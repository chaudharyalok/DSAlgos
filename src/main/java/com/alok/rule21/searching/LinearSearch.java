package com.alok.rule21.searching;

public class LinearSearch {

	public static void main(String[] args) {

		int[] arr = { 5, 1, 9, 3, 0, 6 };
		System.out.println("Element found at:-> " +search(arr, 5));
	}
	
	private static int search(int[] arr, int element){
		
		for(int i =0; i<arr.length;i++){
			if(arr[i] == element){
				return i+1;
			}
		}
		return -1;
	}

}
