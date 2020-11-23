package com.leetcode.searching;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class SubsetSearch {
	public static void main (String[] args) {
		SubsetSearch obj = new SubsetSearch();
		int[] a = new int[]{3,4,12,89,5,67};
		int[] sa = new int[]{3,5,67};
		System.out.println(obj.subsetCheck(a,sa));
	}
	
	String subsetCheck(int[] a,int[] sa){
		//List<Integer> arr =new LinkedList<>();
		
	   Set<Integer> set = new HashSet<Integer>(Arrays.stream(a)
			      .boxed()
			      .collect(Collectors.toList()));
		
	//	Set<Integer> set = new HashSet<Integer>();
		for(int num:a){
			set.add(num);
		}
	
	  for(int each:sa){
		  if(!set.contains(each))
			  return "No";
	  }
	   
	return "Yes";
	}
}
