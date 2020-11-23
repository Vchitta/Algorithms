package com.leetcode.Arrays;

import java.util.Arrays;

public class RotateKArray {
	  public static void rotateArray(int[] array, int k) {
			// Write your code here
			int n = array.length;
	        int i;
			int[] temp = new int[k];
			for( i = 0;i<k;i++){
			    temp[i] = array[i];
			}
			i=k;
			while(i<n){
			    array[i-k]=array[i++]; 
			    
			}
			i=0;int j=n-k;
			while(i<k){
			    array[j++]=temp[i++];
			}
			System.out.println(Arrays.toString(array));
		}
	  static int gcd(int a, int b) 
	    {
	        if (b == 0)
	            return a;
	        else
	            return gcd(b, a % b);
	    }
	  
	  public static void rotateArray2(int[] array, int d) {
		  int n = array.length;
	  int i, j, k, temp;
      for (i = 0; i < gcd(d, n); i++) 
      {
          /* move i-th values of blocks */
          temp = array[i];
          j = i;
          while (1 != 0) 
          {
              k = j + d;
              if (k >= n) 
                  k = k - n;
              if (k == i) 
                  break;
              array[j] = array[k];
              j = k;
          }
          array[j] = temp;
          System.out.println(Arrays.toString(array));
      }
		//System.out.println(Arrays.toString(array));

	  }
	  public static void main(String[] args) {
		  int[] array ={1,2,3,4,5,7,9,10};
		//rotateArray(array, 2);
		rotateArray2(array, 4);
	}

}
