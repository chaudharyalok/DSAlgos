package com.alok.rule21.tree;

import java.util.LinkedList;
import java.util.Queue;

public class Wrapper {

	public static class TreeNode{
		int value;
		TreeNode leftTree;
		TreeNode rightTree;
		TreeNode(int value){
			this.value = value;
		}
	}
	
	private static TreeNode stringToTreeNode(String input){
		
		input = input.trim();
		input = input.substring(1,input.length()-1);
		if(input.length() == 0)
			return null;
		
		 String[] parts = input.split(",");
	     String item = parts[0];
	        
		TreeNode root = new TreeNode(Integer.parseInt(item.trim()));
		
		Queue<TreeNode> treeQueue = new LinkedList<TreeNode>();
		treeQueue.add(root);
		
		int index = 1;
		while(!treeQueue.isEmpty()){
			TreeNode node = treeQueue.remove();
			
			if(index == parts.length)
				break;
			
			item = parts[index++];
			item = item.trim();
			if(!item.equals(null)){
				int leftNumber = Integer.parseInt(item);
				node.leftTree = new TreeNode(leftNumber);
				treeQueue.add(node.leftTree);
			}
			
			if(index == parts.length)
				break;
			
			item = parts[index++];
			item = item.trim();
			if(!item.equals(null)){
				int rightNumber = Integer.parseInt(item);
				node.rightTree = new TreeNode(rightNumber);
				treeQueue.add(node.rightTree);
			}
		}
		
		return root;
	}
	
	private static String nodeToString(TreeNode root){
		
		
		if(root == null)
				return "[]";
		
		String output = "";
		Queue<TreeNode> treeQueue = new LinkedList<TreeNode>();
		treeQueue.add(root);
		
		while(!treeQueue.isEmpty()){
			TreeNode node = treeQueue.remove();
			
			if(node == null){
				output += "null, ";
				continue;
			}
			
			output += String.valueOf(node.value) + ", ";
			
			treeQueue.add(node.leftTree);
			treeQueue.add(node.rightTree);
			
		}
		
		return "[" + output.substring(0, output.length()-2) + "]";
	}
	
	  public static void prettyPrintTree(TreeNode node, String prefix, boolean isLeft) {
	        if (node == null) {
	            System.out.println("Empty tree");
	            return;
	        }
	    
	        if (node.rightTree != null) {
	            prettyPrintTree(node.rightTree, prefix + (isLeft ? "│   " : "    "), false);
	        }
	    
	        System.out.println(prefix + (isLeft ? "└── " : "┌── ") + node.value);
	    
	        if (node.leftTree != null) {
	            prettyPrintTree(node.leftTree, prefix + (isLeft ? "    " : "│   "), true);
	        }
	    }
	    
	    public static void prettyPrintTree(TreeNode node) {
	        prettyPrintTree(node,  "", true);
	    }
	
	public static void main(String[] args) {

		TreeNode node = stringToTreeNode("[1,2,3]");
		prettyPrintTree(node);
	}

}
