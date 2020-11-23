package com.karumanchi.searching;

public class FinkPeak {
	 public static int peakIndexInMountainArray(int[] arr) {
	        
		 if(arr.length<3) return -1;
		 int left=0,right = arr.length-1;
			while(left<=right){
				
				int mid = (right-left)/2+left;
				System.out.println("mid:"+mid+"||ele:"+arr[mid]);
				if(arr[mid]> arr[mid-1] && arr[mid]>arr[mid+1])
					return arr[mid];
				
				else if(arr[mid]> arr[mid-1] && arr[mid]<arr[mid+1]) //inc
					left =mid+1;
					
					else if(arr[mid]< arr[mid-1] && arr[mid]>arr[mid+1]) //dec
						
						right = mid-1;

			} 
		 
	       return -1; 
	        
	    }
	 
	 public static void main(String[] args) {
		System.out.println(peakIndexInMountainArray(new int[]{18,29,38,59,98,100,99,98,90}));
	}
}
