package com.Interviews.pramp;

import java.util.Arrays;

class SolutionPramp1 {
	  
	static int[] findDuplicates(int[] arr1, int[] arr2) {
	    // your code goes here
	    
	    //Base Conditions
	    if(arr1 == null || arr2 == null) {
	      return new int[0];
	    }
	    
	    int i =0;
	    int j=0;
	    int outputLength = arr2.length;
	    
	    if(arr1.length < arr2.length) {
	      outputLength = arr1.length;
	    }
	    
	    
	    int[] output = new int[outputLength];
	    int outIndex =0;
	    
	    while(i < arr1.length  && j < arr2.length) {
	      
	      if(arr1[i] == arr2[j]) {
	        output[outIndex] = arr1[i];
	        i++;
	        j++;   
	        outIndex++;
	      }if(arr1[i] < arr2[j]) {
	        i++;  
	      }if(arr1[i] > arr2[j]) {
	        j++;   
	      }
	      
	    } 
	    
	    return output;
	    
	  }

	  // -5 -4 1 3
	  static int indexEqualsValueSearch(int[] arr) {
	    // your code goes here
	    
	    int len = arr.length;
	    
	    if(arr[0] >len-1 ) return -1;
	   
	    
	    int index =0;
	    for(int i =0;i<len;){
	      
	      index = binarySearch(arr, index,arr.length, i);
	      System.out.println("index least:"+index);
	      //index == i : arr[index] ==i 
	      //the least i you can find at index
	     if(index == i && arr[index] ==i) {
	       
	       return index;
	     }
	     
	     if(index+1 < arr.length && arr[index+1] > index+1) {
	         System.out.println("check index"+arr[index+1]);
	       return -1;
	     }
	       
	     else i = index+1;
	       System.out.println("check i"+i);
	    }
	    
	   
	    return -1;
	    
	    
	  }
	  
	  //-3 -3-3 2
	  static int binarySearch(int[] arr, int left, int right,int key ){
	    
	    int middle;
	    
	    while(right>left+1)
	    {
	      
	      middle = left + (right-left)/2;
	      
	      if(arr[middle] <= key)
	        left = middle;
	      
	      else right = middle;
	      
	      
	    }    
	    
	    
	    return left;
	  }
	  

	  public static void main(String[] args) {
	    
		  System.out.println("Output:"+
                  Arrays.toString(findDuplicates(new int[]{1, 2, 3, 5, 6, 7}, new int[]{3, 6, 7, 8, 20})));
   
    
	    int arr[] = {0};
	    System.out.println("Result for indexEqualsValueSearch:"+indexEqualsValueSearch(arr));

	  }

	}