package com.alok.rule21.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class GraphPath {

	private static class Node {

		int id;
		List<Node> child;

		private Node() {
		}

		private Node(int id) {
			this.id = id;
			child = new LinkedList();
		}
	}

	private void BFS(Node node) {

		Set<Integer> visited = new HashSet();

		Queue<Node> queue = new LinkedList<>();
		queue.add(node);

		while (!queue.isEmpty()) {

			Node temp = queue.poll();

			if (!visited.contains(temp.id)) {
				visited.add(temp.id);
				System.out.print(temp.id + " ");
			}

			for (Node child : temp.child) {
				if (!visited.contains(child.id))
					queue.add(child);
			}
		}
	}
	
	private void DFS(Node node){
		Set<Integer> visited = new HashSet();
		DFS(node, visited);
	}
	
	private void DFS(Node node,Set<Integer> visited){

		visited.add(node.id);
		System.out.print(node.id + " ");
		
		for(Node child : node.child){
			if(!visited.contains(child.id)){
				DFS(child,visited);
			}
		}
	}
	
	private boolean pathExistDFS(Node src, Node dst){
		
		Set<Integer> visited = new HashSet<Integer>();
		return pathExistDFS(src, dst, visited);
	}
	
	private boolean pathExistDFS(Node src, Node dst, Set<Integer> visited){
		
		if(visited.contains(src.id))
			return false;
		visited.add(src.id);
		if(src == dst)
			return true;
		
		for(Node child : src.child){
			if(pathExistDFS(child, dst, visited))
				return true;
		}
		return false;
	}
	
	private boolean pathExistBFS(Node src, Node dst){
		
		Set<Integer> visited = new HashSet<Integer>();
		Queue<Node> queue = new LinkedList<>();
		
		queue.add(src);
		
		while(!queue.isEmpty()){
			
			Node temp = queue.poll();
			
			if(temp == dst)
				return true;
			if(visited.contains(temp.id))
				continue;
			visited.add(temp.id);
			
			for(Node child : temp.child){
				queue.add(child);
			}
			
		}
		return false;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node node0 = new Node(0);
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);

		node0.child.add(node1);
		node0.child.add(node2);

		node1.child.add(node0);
		node1.child.add(node3);

		node2.child.add(node0);
	//	node2.child.add(node1);
		node2.child.add(node3);

		node3.child.add(node2);
		node3.child.add(node1);
		
		Node node4 = new Node(4);

		GraphPath gp = new GraphPath();
	//	gp.BFS(node0);
		System.out.println(gp.pathExistBFS(node0, node1));

	}

}
