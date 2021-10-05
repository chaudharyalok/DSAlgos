package com.alok.rule21.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphTraversal {
	
	int V; // no of vertices
	LinkedList<Integer> adjacent[];	//  adjacent lists
	
	GraphTraversal(int v){
		V= v;
		adjacent = new LinkedList[v];
		for(int i=0;i<v;i++){
			adjacent[i] = new LinkedList<>();
		}
	}
	
	// function to add an edge in the graph
	private void addEdge(int v, int e){
		adjacent[v].add(e);
	}
	
	// print BFS from a given source
	private void BFS(int s){
		// by deafult all vertices are not visited
		boolean visited[] = new boolean[V];
		
		// queue for BFS
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(s);
		
		visited[s]= true;
		
		while(!queue.isEmpty()){
			
			s = queue.poll();
			
			System.out.print(s + " ");
			
			Iterator<Integer> i = adjacent[s].listIterator();
			while(i.hasNext()){
				int n = i.next();
				if(!visited[n]){
					visited[n] = true;
					queue.add(n);
				}
			}
		}
		
	}
	
	private void DFS(int s){
		
		boolean visited[] = new boolean[V];
		
		DFSUtil(s, visited);
	}
	
	private void DFSUtil(int s, boolean[] visited){
		
		visited[s] = true;
		
		System.out.print(s + " ");
		
		Iterator<Integer> i = adjacent[s].listIterator();
		while(i.hasNext()){
			int n = i.next();
			if(!visited[n]){
				DFSUtil(n, visited);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GraphTraversal gt = new GraphTraversal(4);
		gt.addEdge(0, 1);
		gt.addEdge(0, 2);
		gt.addEdge(1, 2);
		gt.addEdge(2, 0);
		gt.addEdge(2, 3);
		gt.addEdge(3, 3);
		
		gt.BFS(0);
	}

}
