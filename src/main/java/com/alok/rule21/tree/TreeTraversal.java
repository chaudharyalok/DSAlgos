package com.alok.rule21.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

	/**
	 * recursive
	 * @param node
	 */
	private void inorderDFS(Node node) {

		if (node == null)
			return;

		inorderDFS(node.left);
		System.out.print(node.value + " ");
		inorderDFS(node.right);

	}
	
	/**
	 * recursive
	 * @param node
	 */
	private void preorderDFS(Node node) {

		if (node == null)
			return;

		System.out.print(node.value + " ");
		preorderDFS(node.left);
		preorderDFS(node.right);

	}

	/**
	 * recursive
	 * @param node
	 */
	private void postorderDFS(Node node) {

		if (node == null)
			return;

		postorderDFS(node.left);
		postorderDFS(node.right);
		System.out.print(node.value + " ");
	}
	
	private void printLevelOrder(Node root){
		
		int height = height(root);
		for(int i = 1; i<=height;i++){
			printCurrentLevel(root, i);
		}
	}
	
	private void printCurrentLevel(Node node, int level){
		
		if(node == null)
			return;
		 if(level == 1)
		{
			System.out.print(node.value + " ");
		}
		else if(level>1){
			printCurrentLevel(node.left, level-1);
			printCurrentLevel(node.right, level-1);
		}
	}
	
	private int height(Node root){
		
		if(root == null)
			return 0;
		
		int heightLeft = height(root.left);
		int heightRight = height(root.right);
		
		if(heightLeft>heightRight)
			return heightLeft+1;
		else return heightRight+1;
		
		
	}
	
	static int max_level = 0;
	private void leftViewTree(Node node){
		leftViewTreeUtil(node, 1);
	}
	private void leftViewTreeUtil(Node node,int level){
		
		if(node == null)
			return;
		if(max_level < level){
			System.out.print(node.value + " ");
			max_level = level;
		}
		
		leftViewTreeUtil(node.left, level+1);
		leftViewTreeUtil(node.right, level+1);
	}
	
	private void printLeftViewQueue(Node node){
		
		if(node == null)
			return;
		Queue<Node> queue = new LinkedList<>();
		
		queue.add(node);
		
		while(!queue.isEmpty()){
		
			int size = queue.size();
			for(int i = 0; i<size;i++){
				Node temp = queue.poll();
				
				if(i == 0)
					System.out.print(temp.value + " ");
				
				if(temp.left != null)
					queue.add(temp.left);
				if(temp.right != null)
					queue.add(temp.right);
				
			}
		}
	}
	
	/**
	 * iterative inorder traversal 
	 * @param args
	 */
	private void inOrderItr(Node root){
		
		if(root == null)
			return;
		Node curr = root;
		Stack<Node> stack = new Stack<Node>();
		
		while(curr != null || stack.size() > 0){
			while(curr != null){
				stack.push(curr);
				curr = curr.left;
			}
			 curr = stack.pop();
			 System.out.println(curr.value + " ");
			 curr = curr.right;
		}
	}
	
	/**
	 * iterative preorder traversal
	 * @param args
	 */
	private void preOrder(Node root){
		if(root == null)
			return;
		
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		
		while(stack.isEmpty() == false){
			Node node = stack.pop();
			System.out.println(node.value + " ");
			
			if(node.right != null)
				stack.push(node.right);
			if(node.left != null)
				stack.push(node.left);
		}
		
	}

	public static void main(String[] args) {

		Node root = new Node(5);
		Node left1 = new Node(3);
		Node right1 = new Node(1);

		root.left = left1;
		root.right = right1;
		root.left.right = new Node(6);

		Node four = new Node(2);
		root.left.left = four;
		root.right.left = new Node(4);

		TreeTraversal bfs = new TreeTraversal();
	//	bfs.inorderLeftSubTreeDFS(root,true);
	//	bfs.inorderDFS(root);
		
		bfs.leftViewTree(root);
		System.out.println();
		bfs.printLeftViewQueue(root);
		

	}

}
