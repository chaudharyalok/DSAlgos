package com.alok.rule21.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

public class BinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node rootNode = null;
		rootNode = addNode(rootNode, 50);
		rootNode = addNode(rootNode, 30);
		rootNode = addNode(rootNode, 70);
		rootNode = addNode(rootNode, 20);
		rootNode = addNode(rootNode, 40);
		rootNode = addNode(rootNode, 10);
		rootNode = addNode(rootNode, 25);
		rootNode = addNode(rootNode, 60);
		rootNode = addNode(rootNode, 80);
		

		List<LinkedList<Node>> lists = createLinkedListOfNodesAtEachLevel(rootNode);
		
	}
	
	private static List<LinkedList<Node>> createLinkedListOfNodesAtEachLevel(Node rootNode){
		
		if(rootNode == null)
			return null;
		
		List<LinkedList<Node>> linkedList = new LinkedList<>();
		Queue<Node> currentLevel = new LinkedList<>();
		
		currentLevel.add(rootNode);
		
		Queue<Node> nextLevel = new LinkedList<>();
		linkedList.add(new LinkedList<>());
		
		while(!currentLevel.isEmpty()){
			
			Node node = currentLevel.poll();
			linkedList.get(linkedList.size() -1).add(node);
			System.out.print(node.data + ",");
			
			if(node.left != null)
				nextLevel.add(node.left);
			
			if(node.right != null)
				nextLevel.add(node.right);
			
			if(currentLevel.isEmpty() && !nextLevel.isEmpty()){
				currentLevel = nextLevel;
				nextLevel = new LinkedList<>();
				linkedList.add(new LinkedList<>());
				System.out.println();
			}
		}
		return linkedList;
	}
	
	private static Node addNode(Node node, int value){
		
		if(node == null)
			return new Node(value);
		else{
			if(value > node.data){
				Node newNode = addNode(node.right,value);
				node.right = newNode;
			} else{
				Node newNode = addNode(node.left,value);
				node.left = newNode;
			}
			return node;
		}
	}
	
	private static class Node{
		private int data;
		private Node left;
		private Node right;
		
		public Node(int data){
			this.data = data;
		}
	}

}
