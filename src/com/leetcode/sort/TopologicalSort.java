package com.leetcode.sort;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.structure.*;


public class TopologicalSort {
	
	static List<List<Integer>> topsort(Graph graph){
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Map<Integer,Integer> indegree = new HashMap<Integer,Integer>();
		List<Integer>currentNodes = new LinkedList<Integer>();
		List<Integer> temp = null;
		for(Map.Entry<Integer, List<Integer>> edge: graph.edges.entrySet()){
			for(int vertex:edge.getValue()){
				indegree.putIfAbsent(vertex, 0);
				indegree.put(vertex, indegree.get(vertex)+1);				
			}
		}
		System.out.println(indegree);
		for(Map.Entry<Integer, List<Integer>> edge: graph.edges.entrySet()){
				if(indegree.get(edge.getKey())==null)	{
					currentNodes.add(edge.getKey());
			}
		}
		
		
		while(!currentNodes.isEmpty()){
			for(int node:currentNodes){
				temp = new LinkedList<Integer>();
				if(graph.edges.get(node)!=null)
				for(int nodes:graph.edges.get(node)){	
					int count = indegree.get(nodes)-1;
					indegree.put(nodes, count);
					System.out.println(count);
					if(count ==0){
						System.out.println(nodes);
						temp.add(nodes);
						System.out.println(temp+"-->");
					}
				}
			}
			result.add(currentNodes);
			currentNodes = new LinkedList<Integer>(temp);	

		}
		return result;	
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
		 
		 System.out.println((topsort(graph)));
	 }

}
