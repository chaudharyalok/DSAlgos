package com.alok.rule21.ll;

public class Wrapper {
	
	public static class ListNode{
		
		int node;
		ListNode next;
		ListNode(int value){
			node = value;
		}
	}
	
	private static int[] stringToIntegerArray(String input){
		
		input = input.trim();
		input = input.substring(1,input.length()-1);
		if(input.length() == 0)
			return new int[0];
		String[] array = input.split(",");
		int[] arr = new int[array.length];
		for(int index= 0; index < array.length; index++){
			arr[index] = Integer.parseInt(array[index].trim());
			
		}
		return arr;
	}
	
	private static ListNode stringToListNode(String input){
		int[] arr = stringToIntegerArray(input);
		ListNode dummyNode = new ListNode(0);
		ListNode ptr = dummyNode;
		for(int value : arr){
			ptr.next = new ListNode(value);
			ptr = ptr.next;	
		}
		return dummyNode.next;
		
	}
	
	   public static void prettyPrintLinkedList(ListNode node) {
		      while (node != null && node.next != null) {
		          System.out.print(node.node + "->");
		          node = node.next;
		      }
		    
		      if (node != null) {
		        System.out.println(node.node);
		      } else {
		        System.out.println("Empty LinkedList");
		      }
		    
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node = stringToListNode("[3,5,1,7,9]");
		prettyPrintLinkedList(node);

	}

}
