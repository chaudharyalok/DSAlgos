package com.alok.rule21.arrays;

public class MissingDuplicate {

	public static void main(String[] args) {

		int[] arr = {2,1,1,2,3};
	//	missing(arr,true);
	//	duplicate2(arr);
		single(arr);
	}
	
	private static void missing(int[] arr,boolean indexZeroased){
	
		int n = arr.length+1;
		int IdleTotal = n*(n+1)/2;
		if(indexZeroased)
			IdleTotal = n*(n-1)/2;
		
		int actualTotal = 0;
		for(int a: arr){
			actualTotal+=a;
		}
		
		System.out.println("missing element: "+ (IdleTotal-actualTotal));
	}
	
	private static void duplicate(int[] arr){
	
		for(int i=0; i<arr.length; i++){
			int j = Math.abs(arr[i]);
			if(arr[j] >= 0)
				arr[j] = -arr[j];
			else 
				System.out.println("dup ele:" + j);
		}
	}
	
	private static void duplicate2(int[] arr){
		
		int n = arr.length;
		for(int i=0; i<n; i++){
			arr[arr[i]%n] = arr[arr[i]%n] + n;
		}
		
		for(int i=0; i<n; i++){
			if(arr[i] >= n*2)
				System.out.println(i);
		}
	}
	
	private static void single(int[] arr){
		
		int a = arr[0];
		for(int i=1; i<arr.length;i++){
			a^=arr[i];
		}
		
		System.out.println(a);
	}

}
