package com.alok.rule21.ll;

public class AddTwoNumbersLC {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(0);
		l1.next = new ListNode(1);
		
		ListNode l2 = new ListNode(0);
		l2.next = new ListNode(1);
		
		ListNode ll = addTwoNumbers(l1, l2);
		
		printLinkedList(ll);
		System.out.println();
	//	printLinkedList(l2);

	}

	private static void printLinkedList(ListNode ll){
		
		while(ll != null){
			
			System.out.print(ll.val + " ");
			ll = ll.next;
		}
	}
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		ListNode dummyNode = new ListNode(0);
		
		if(l1.val == 0 && l2.val == 0 && l1.next == null && l2.next == null)
			return dummyNode;

		ListNode ptr = dummyNode;
		int carry = 0;
		while(l1 != null && l2 != null){
			
			int sum = (l1.val + l2.val + carry)%10;
			carry = (l1.val + l2.val + carry)/10;
			ptr.next = new ListNode(sum);
			ptr = ptr.next;
			
			l1 = l1.next;
			l2 = l2.next;
			
		}
		
		
		while(l1 != null){
			int sum = (l1.val + carry)%10;
			carry = (l1.val + carry)/10;
			ptr.next = new ListNode(sum);
			ptr = ptr.next;
			
			l1 = l1.next;
		}
		
		while(l2 != null){
			int sum = (l2.val + carry)%10;
			carry = (l2.val + carry)/10;
			ptr.next = new ListNode(sum);
			ptr = ptr.next;
			
			l2 = l2.next;
		}
		if(carry !=0)
			ptr.next = new ListNode(carry);
			
		
		
		return dummyNode.next;
	}

}
