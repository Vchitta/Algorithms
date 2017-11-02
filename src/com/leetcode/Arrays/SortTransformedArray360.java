package com.leetcode.Arrays;
import java.util.Arrays;
import java.lang.Math;
/**
 * Created by vidyachitta on 5/21/17.
 */
public class SortTransformedArray360 {
    public static int Bsearch(int[] arr,int ele){
        int low = 0,mid =0,high = arr.length;
        while(low<high){
            mid = (low+high)/2;
           if( ele == arr[mid]){
                return mid;
            }
           if (ele > arr[mid])
               low = mid+1;
           else
               high = mid;
        }
        return mid;
    }
    public static int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int size = nums.length;
        if (size == 0){
            return new int[] {};
        }
        int x;int ele;
        int [] sum = new int[size];
        int [] sum1 = new int[size];
        for (int i=0;i<size;i++){
             x= nums [i];
             ele = (int) (a*(Math.pow(x,2))+b*x+c);
             sum1[i] = ele;
             //int pos = Bsearch(nums,ele);

             //System.arraycopy(nums,0,sum,0,pos-1);

             //for (int j=i;j>-1;j--){
             int j = i-1;
             while (j >= 0 && ele < sum[j]) {
                 sum[j + 1] = sum[j];
                 j--;
             }
             sum[j+1]=ele;
             }

        System.out.println(Arrays.toString(sum1));
        return sum;
    }

    public static void main(String[] args) {
//        Scanner input= new Scanner(System.in);
//        String s = input.nextLine();
        int[] arr = {-5,1,2,3,9,22};
        System.out.println(Arrays.toString(sortTransformedArray(arr,-5,-10000,4)));
        //s = arr;



    }

}
