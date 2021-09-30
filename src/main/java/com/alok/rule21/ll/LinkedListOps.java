package com.alok.rule21.ll;

public class LinkedListOps {

	private static class Node {

		int value;
		Node next;

		public Node() {
		}

		public Node(int value) {
			this.value = value;
			this.next = null;
		}

	}

	private void traversal(Node node) {

		if (node == null) {
			System.out.println("empty list");
			return;
		}

		while (node != null) {
			System.out.print(node.value + "->");
			node = node.next;
		}

	}

	private Node reverseLL(Node node) {

		Node current = node;
		Node next = null;
		Node prev = null;

		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;

		}

		return prev;

	}

	public static void main(String[] args) {
		Node head = new Node(2);
		head.next = new Node(3);
		head.next.next = new Node(4);
		head.next.next.next = new Node(5);

		LinkedListOps ll = new LinkedListOps();
		ll.traversal(head);

		Node newHead = ll.reverseLL(head);
		System.out.println("");
		ll.traversal(newHead);

	}

}
