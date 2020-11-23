package com.prep.amazon;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
	   public List<Integer> partitionLabels(String S) {
	        List<Integer> res = new ArrayList<>();
	        for(int i =0;i<S.length();i++){
	     
	        	int maxEnd = S.lastIndexOf(S.charAt(i));
	        	String partition = S.substring(i, maxEnd+1);
	        	
	        	System.out.println("staartn partition:"+partition+"with i:"+i+" j:"+maxEnd);

	        	for(int j=0;i+j<maxEnd;j++){  
	        		char ch = S.charAt(i+j);
	        		
	        		int end=S.lastIndexOf(ch);
		        	System.out.println("for ch:"+ch+"end:"+end);

	        		if(end>maxEnd)
	        			maxEnd =end;
	        	}
	        	
	        	System.out.println("partition:"+S.substring(i,maxEnd+1)+"with i:"+i+" j:"+maxEnd);

	        	res.add(maxEnd+1-i);
	        	i=maxEnd;
	    }
			return res;
	        
	   }
	   
	public static void main(String[] args) {
		System.out.println("ababcbacadefegdehijhklij".length());
		System.out.println(new PartitionLabels().partitionLabels("qiejxqfnqceocmy"));
	}
}
