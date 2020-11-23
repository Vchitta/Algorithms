package com.structure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Graph {
	/*A graph is mplemented by array of linkedlists
	 * where index in array tells the incident vertex and 
	 * the list at that index has list of vertices it has edge towards
	 * */
	
//	public List<Integer> edges[];
	public List<Integer> vertices;
	public int nVertices;
	public Map <Integer,List<Integer>> edges;
	public Graph(){
		vertices = new ArrayList<Integer>();
		edges = new HashMap<>();
	}
	
	public void addEdge(int s, int e){
		vertices.add(s);
		vertices.add(e);	
		edges.putIfAbsent(s, new ArrayList<>());
		edges.get(s).add(e);
		}
	public void printGraph(){
		for(Map.Entry<Integer,List<Integer>> edge:edges.entrySet()){
			System.out.println("from the vertex: "+ edge.getKey()+" to: "+edge.getValue());
		}
	}
	 public static void main(String[] args) {
		 
	        Graph graph = new Graph();
	        graph.addEdge( 0, 1);
	        graph.  addEdge( 0, 4);
	        graph. addEdge( 1, 2);
	        graph. addEdge( 1, 3);
	        graph. addEdge(1, 4);
	        graph. addEdge( 2, 3);
	        graph.  addEdge(3, 4);
	        
	        graph.printGraph();
		 
	 }
	
}
