package com.alok.rule21.sorting;

public class BubbleSort {

	/**
	 * in place sorting
	 * worst time complexity of O(n^2)
	 * best of O(n) when array is already sorted
	 * auxiliary space O(1)
	 * optimization: if inner loop makes no swap, stop the algo
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

	private static void sort(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = temp;
				}
			}
		}

	}
	
	private static void sortOptimized(int[] arr) {
		int n = arr.length;
		boolean swapped = false;
		for (int i = 0; i < n - 1; i++) {
			swapped = false;
			for (int j = 0; j < n - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = temp;
					swapped = true;
				}
			}
			// if no 2 elements were swapped by inner loop
			//then break
			if(swapped == false)
				break;
		}

	}

}
