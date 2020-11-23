package com.leetcode.Arrays;

import java.util.Arrays;

public class PeakElement {
/*Find the element before which all the elements are smaller than it,
 *  and after which all are greater
*/
	static int findElement(int[] arr){
		int len=arr.length;
		int maxEle = Integer.MIN_VALUE;
		int[] temp = new int[len];
		
		for(int i=0;i<len;i++){
			if(arr[i]>maxEle){
				maxEle=arr[i];
			}
			temp[i] = maxEle;
		}
		int minEle = Integer.MAX_VALUE;
		 maxEle = Integer.MIN_VALUE;
		for(int i=len-1;i>=0;i--){
//			if(arr[len-i-1]>maxEle)
//				maxEle=arr[i];
//			
			if(arr[i]<minEle)
				minEle=arr[i];
			//System.out.println(maxEle+"--> "+arr[i]+" "+minEle);
			
		//	System.out.println(temp[i]+" "+arr[i]+" "+minEle);
			if(temp[i]<=arr[i] && arr[i]<=minEle)
				return i;
			
		}
		
		//System.out.println(Arrays.toString(temp));
		
		return -1;
		
	}
	
	static void printArray(int[] arr){
		int len = arr.length;
		for(int i= len-1;i>=0;i--){
			System.out.println(i+"--->"+(len-i-1));
		}
	}
	public static void main(String[] args) {
		int[] arr ={5, 1, 4, 3, 6, 8, 10, 7, 9};
		System.out.println(findElement(arr));
		//printArray(arr);
	}
	
	
}
