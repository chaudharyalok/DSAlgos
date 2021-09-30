package com.alok.rule21.dp;

public class MaxCost {

	/* You can travel only north(up) or east(right)
	 * Optimal path problem
	 * 					{{0,0,0,0,5}, new york (finish)
	 * 			 		{0,1,1,1,0},
	 * 	so_cal (start)	{2,0,0,0,0}}
	 *  The total for this example would be 10 (2+0+1+1+1+0+5)
	 */
	public static void main(String[] args) {

		int[][] costs = {{0,0,0,0,5}, {0,1,1,1,5}, {2,0,0,0,0}};
		System.out.println(maxCost(costs));
		
	}
	
	private static int maxCost(int[][] costs){
		
		int m = 0;
		int n = costs[0].length-1;
		return maxCost(costs, m, n);
	}
	
	private static int maxCost(int[][] costs, int m, int n){
	
		if(m > costs.length-1 || n<0){
			return Integer.MIN_VALUE;
		} else if(m == costs.length-1 && n == 0){
			return costs[m][n];
		} else{
			return costs[m][n] + max(maxCost(costs, m, n-1),maxCost(costs, m+1, n));
		}
	}
	
	private static int max(int a, int b){
		return (a>b)? a : b;
	}

}
