package com.alok.rule21.tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeTraversal {

	private static class Node {

		int value;
		Node left, right;

		public Node() {
		}

		public Node(int value) {
			this.value = value;
			this.left = null;
			this.right = null;
		}

	}

	private void parseBFS(Node node) {

		if (node == null)
			return;
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(node);

		while (queue.size() != 0) {

			Node current = queue.poll();
			System.out.print(current.value + " ");
			if (current.left != null)
				queue.add(current.left);
			if (current.right != null)
				queue.add(current.right);
		}

	}

	private void inorderDFS(Node node) {

		if (node == null)
			return;

		inorderDFS(node.left);
		System.out.print(node.value + " ");
		inorderDFS(node.right);

	}

	private void preorderDFS(Node node) {

		if (node == null)
			return;

		System.out.print(node.value + " ");
		preorderDFS(node.left);
		preorderDFS(node.right);

	}

	private void postorderDFS(Node node) {

		if (node == null)
			return;

		postorderDFS(node.left);
		postorderDFS(node.right);
		System.out.print(node.value + " ");
	}

	public static void main(String[] args) {

		Node root = new Node(5);
		Node left1 = new Node(3);
		Node right1 = new Node(1);

		root.left = left1;
		root.right = right1;

		Node four = new Node(2);
		root.left.left = four;
		root.right.left = new Node(4);

		TreeTraversal bfs = new TreeTraversal();
		bfs.postorderDFS(root);

	}

}
