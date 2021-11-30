package com.alok.rule21.sorting;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

public class QuickSort {

	/**
	 * general  T(n) = T(k) + T(n-k-1) + \theta(n)
	 * best case  T(n) = 2T(n/2) + \theta(n) time complexity of O(nlogn)
	 * worst case T(n) = T(n-1) + \theta(n), O(n^2)
	 * in place sorting, extra space used only for recursive call in stack
	 */
	public static void main(String[] args) {

		int[] arr = { 5, 1, 9, 3, 0, 6 };
		//sort(arr, 0, arr.length-1);
		//printArray(arr);
	//	System.out.println(ordinal(274));
		
	//	balanced(Arrays.asList("{}()","({()})","{}(","[]"));
		conversion();
	}
	
	private static void printArray(int[] arr) {
		for (int a : arr) {
			System.out.print(a + "┌── ┌");
		}
	}
	
	private static void sort(int[] arr,int low, int high){
		
		if(low<high){
		int m = partition(arr, low, high);
		
		sort(arr, low, m-1);
		sort(arr, m+1, high);
		}
	}
	
	private static void swap(int[] arr, int i, int j){
	
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	private static int partition(int[] arr, int low, int high){
		
		int pivot = arr[high];
		int i = low-1;
		
		for(int j=low; j<=high-1; j++){
			if(arr[j]<pivot){
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i+1, high);
		return i+1;
	}
	
	private static String mask(String input){
		if(input.length() <= 6)
			return input;
		StringBuffer result = new StringBuffer();
		for (int i=1; i<input.length(); i++)
        {
            if (i!=1&&Character.isDigit(input.charAt(i)) && i<input.length()-4)
            	result.append('#');
            else result.append(input.charAt(i));
        }
		
		input = result.toString();
		return input;
	}
	
	private static String mask1(String input){
		if(input.length() <= 6)
			return input;
		StringBuffer result = new StringBuffer();
		for (int i=0; i<input.length(); i++)
        {
            if (i!=0 && input.charAt(i) >= 48 && input.charAt(i) <= 57 && i<input.length()-4)
            	result.append('#');
            else result.append(input.charAt(i));
        }
		
		input = result.toString();
		return input;
	}
	
	private static String ordinal(Integer number){
		
		String result = null;
		if(number%10 == 1 && number != 11)
			result = number+ "st";
		else if(number%10 == 2 && number != 12)
			result = number+ "nd";
		else if(number%10 == 3 && number != 13)
			result = number+ "rd";
		else 
			result = number+ "th";
		return result;
	}
	
	private static double poolish(String input){
		
        Stack<String> stack = new Stack<String>();
        String[] arr = input.split(" ");
        String operation;
        int x, y;
        int value =0;
        for(String symbol: arr){
        	if(!symbol.equals("+") && !symbol.equals("-") && !symbol.equals("*") && !symbol.equals("/")){
        		stack.push(symbol);
        		continue;
        	}	
        		else{
        			operation = symbol;
        		}
        		x = Integer.parseInt(stack.pop());
        		y = Integer.parseInt(stack.pop());
        		if(operation.equals("+")){
        		int operandc = 0;
        		if(symbol.equals("+")){
        			
        		}
        	}
        }
		return (double)Integer.parseInt(stack.pop());
	}
	
	private static void balanced(List<String> inputs){
		
		for(String input : inputs){
			char[] array = input.toCharArray();
			Stack<Character> stack = new Stack<Character>();
			boolean flag = true;
			for(char character : array){
			 if('{'==character || '['==character || '('==character){
	                stack.push(character);
	            } else{
	            	Character top = null;
	            	try{
	                 top = stack.pop();}
	            	catch(EmptyStackException exp){
	            		flag = false;
	                	break;
	            	}
	              /*  if(top == null){
	                	flag = false;
	                	break;
	                }*/
	                 if('}'==character && '{'!=top){
	                	flag = false;
	                	break;
	                }
	                else if(']'==character && '['!=top){
	                	flag = false;
	                	break;
	                }
	                else if(')'==character && '('!=top){
	                	flag = false;
	                	break;
	                }
	            }
			}
			if(!stack.empty())
				flag = false;
			System.out.println(flag);
			
		}
	} 
	
	private static void conversion(){
		String input = "alok";
		input = input.substring(1, input.length() - 1);
		System.out.println(input);
		
	}

}
