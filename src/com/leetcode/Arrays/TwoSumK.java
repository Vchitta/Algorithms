package com.leetcode.Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumK {
	
	
public static void main(String[] args) {
	int[] array ={1,2,3,4};
	System.out.println(Arrays.toString(twoSumK(array,7)));
	
}
static int[] twoSumK1(int[] array, int k) {
	
	Arrays.sort(array);
	int len = array.length;
	int[] result=new int[2];
	for(int i =0, j = len-1;i<j;){
		if(array[i]+array[j]==k){
			result[0] = array[i];
			 result[1]= array[j];
			 return result;
		}else if (array[i]+array[j]<k)
			i++;
		else j--;
			
		
	}
	
	
	return null;
	
}
 static int[] twoSumK(int[] array, int k) {
	 int[] result = new int[2];
	 Map<Integer,Integer> map = new HashMap<>();
	 
	 for(int i =0;i<array.length;i++){
		 
		 if(map.containsKey(k -array[i])){
			 result[0] = array[i];
			 result[1]= array[map.get(k-array[i])];
			 return result;
		 }
		 
		 map.put(array[i], i);
	 }
	 System.out.println(map);
	 return null;
}
}
