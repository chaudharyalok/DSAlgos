package com.alok.rule21.arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSumLC {

	public static void main(String[] args) {

		int[] input = {2,7,11,15};
		int[] output = sol2(input, 9);
		for(int a: output){
			System.out.print(a);
		}
		
	}
	
	/**
	 * 
	 * @param nums
	 * @param target
	 * @return
	 * in 44 ms & 39.1 mb
	 */
	private static int[] sol1(int[] nums, int target){
	       int[] result = new int[2];
	        for(int i =0; i<nums.length-1;i++){
	            for(int j=i+1; j<nums.length;j++){
	                if(nums[i]+nums[j] == target){
	                    result[0]=i;
	                    result[1]=j;
	                    break;
	                }
	            }
	        }
	        return result;
	}
	
	/**
	 * 
	 * @param nums
	 * @param target
	 * @return
	 * in 
	 */
	private static int[] sol2(int[] nums, int target){
		
		int[] result = new int[2];
		if(nums.length == result.length){
			result[0] = 0;
			result[1] = 1;
			return result;
		}
			
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i =0; i<nums.length;i++){
			int diff = target - nums[i];
			if(map.containsKey(diff)){
				result[0] = map.get(diff);
				result[1] = i;
			//	return result;
			} else
			map.put(nums[i], i);
		}
		
/*		for(int a=0; a<nums.length;a++){
			int diff = target-nums[a];
			if(map.containsKey(diff) && diff != nums[a]){
				int value = map.get(diff);
				
				result[0] = a;
				result[1] = value;
				break;
			
			}
		}*/
		return result;
	}

}
