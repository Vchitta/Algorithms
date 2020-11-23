package com.leetcode.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumK {
	static List<List<Integer>> threeSumK(int[] array,int C){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for(int i=0;i<array.length;i++){
		
			for(int j=i+1,k=array.length-1;j<k;){
				if(array[i]+array[j]+array[k]==C){
					List<Integer> list = new ArrayList<>();
					list.add(i);
					list.add(j);
					list.add(k);
					result.add(list);
					return result;
				}
				if(array[i]+array[j]+array[k]<C){
					j--;
				}
				if(array[i]+array[j]+array[k]<C){
					i++;
				}
			}
		}
		
		
		
		return null;
		
	}
	public static void main(String[] args) {
		
		int[] array ={1,2,3,4};
		System.out.println(threeSumK(array,7));
	}

}
