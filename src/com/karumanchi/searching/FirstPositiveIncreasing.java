package com.karumanchi.searching;

public class FirstPositiveIncreasing {
	
	int searchFirstPositive(int arr[]){
		
		int left=0,right = arr.length-1;
		while(right-left>1){
			int mid = (right-left)/2+left;
		
			if(arr[mid] >0){
				right =mid;
			} else left = mid;
		
		}
		
		return arr[right];
	}

	
	public static void main(String[] args) {
		System.out.println(new FirstPositiveIncreasing().searchFirstPositive(new int[]{-5,-4,-3,-2,-1,0,1,2,4,5,6
		}));
	}
}
