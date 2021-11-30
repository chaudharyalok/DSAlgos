package com.alok.rule21.arrays;

public class CarProbIntw {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {4,1,2,5};
	//	System.out.println(overtakes(arr));
		System.out.println(overtakes2(arr,0,arr.length-1));
		printArray(arr);
	}
	
	private static void printArray(int[] arr) {
		for (int a : arr) {
			System.out.print(a + " ");
		}
	}
	
	private static int overtakes(int[] arr){
		
		int overtakes = 0;
		
		for(int i=0; i<arr.length-1;i++){
			for(int j = i+1;j<arr.length;j++){
			
				if(arr[i]>arr[j])
					overtakes++;
			}
		}
		
		return overtakes;
	}
	
	private static int overtakes2(int[] arr,int l, int r){
		int count = 0;
		if(l<r){
	int m = l + (r-l)/2;
	System.out.println("l="+l+"&r="+r);
	
	int count1 = overtakes2(arr, l, m);
	int count2 = overtakes2(arr, m+1, r);
	
	int count3 = merge(arr, l, m, r);
	
	 count = count1 + count2 + count3;
		}
		return count;
	}
	
	private static int merge(int[] arr, int l, int m, int r){
		
		int count = 0;
		int n1 = m-l+1;
		int n2 = r-m; 
		
		int[] L = new int[n1];
		int[] R = new int[n2];
		
		// copy data to temp array
		for(int i=0;i<n1;i++)
			L[i] = arr[l+i];
		for(int j=0;j<n2;j++)
			R[j] = arr[m+1+j];
		
		int i=0,j=0;
			
		int k =l;
		while(i<n1 &&j<n2){
			if(L[i] > R[j]){
				arr[k++] = L[i++];
				count += (n2-j); 
			}else{
				arr[k++] = R[j++];
			}
		}
		while(i<n1){
			arr[k++] = L[i++];
		}
		while(j<n2){
			arr[k++] = R[j++];
		}
		
		return count;
	}

}
