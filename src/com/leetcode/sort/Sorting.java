package com.leetcode.sort;

import java.util.Arrays;

public class Sorting {
	static int[] insertionSort(int[] input){
		
		for(int i =1;i<input.length;i++){
			int temp = input[i];
			int j =i;
			while(j>0 && temp<input[j-1]){
				input[j]=input[j-1];
				j--;
			}
			input[j] = temp;
		}
		return input;
	}
	
	static int[] selectionSort(int[] input){
		for(int pass=0;pass<input.length;pass++){
			int largeIndex = findSmallest(input,pass);
			if(largeIndex!=pass){
				input = swap(input,largeIndex,pass);
			}
			
		}
		
		return input;
		
	}
	static int[] swap(int[] input,int a,int b){
		input[a]=input[b]+input[a];
		input[b]=input[a]-input[b];
		input[a]=input[a]-input[b];
		return input;
	}
	 static int findSmallest(int[] input,int start) {
		 int temp = input[start];
		 int largeIndex = start;
		for(int i=start+1;i<input.length;i++){
			if(input[i]<temp){
				temp=input[i];
				largeIndex = i;
			}
		}
		return largeIndex;
	}

		private static int isSorted(int[] input) {
			boolean swapped = true;
			int pass;
			for( pass=0;pass<input.length&&swapped;pass++){
				//System.out.println(pass);
			//	System.out.println(Arrays.toString(input));
				swapped = false;
				for(int j= pass;j<input.length;j++){
					if(input[pass]>input[j]){
						swapped=true;
						input = swap(input, pass,j);
					}
				}
			//	System.out.println(pass);
			}
			//return input;
			return pass;
		}

		private static int[] bubbleSort(int[] input) {
			
			for(int pass=0;pass<input.length;pass++){
				for(int j= pass;j<input.length;j++){
					if(input[pass]>input[j]){
						input = swap(input, pass,j);
					}
				}
			}
			return input;
		}

	
	public static void main(String[] args){
		int input[]={5,2,7,9,3,4,0};
		System.out.println(Arrays.toString(input));


		//System.out.println(Arrays.toString(insertionSort(input)));
		
		//System.out.println(Arrays.toString(selectionSort(input)));
		System.out.println(Arrays.toString(mergeSort(input,0,input.length-1)));
		//System.out.println(Arrays.toString(input));
		//System.out.println(isSorted(input));
	//	System.out.println(isSorted(insertionSort(input)));



	}

	private static int[] mergeSort(int[] input, int low,int high) {
		
		if(low<high){
			 int mid = (high+low)/2;
				System.out.println(low+"   "+mid+"   "+(mid+1)+"   "+high);

			 mergeSort(input,low,mid);
			 mergeSort(input,mid+1,high);
			 mergeSortUtil(input,low,mid,high);
		}
		return input;
	}

	private static void mergeSortUtil(int[] input, int low, int mid, int high) {
		int firstLen = mid-low+1,secondLen= high-mid;
		int[] first = Arrays.copyOf(input, mid-low+1);
		int[] second = new int[high-mid];
		System.arraycopy(input, mid+1, second, 0, high-mid);
		System.out.println(Arrays.toString(first));
		System.out.println(Arrays.toString(second));

		int i=0,j=0;
		int k=low;
		while(i<firstLen && j<secondLen){
			if(first[i]<=second[j])
				input[k++]=first[i++];
			else input[k++]=second[j++];
		}
		while(i<firstLen){
			input[k++]=first[i++];
		}
		
		while(j< secondLen){
			input[k++]=second[j++];
		}
		
	}

}
