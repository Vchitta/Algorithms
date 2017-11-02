package com.leetcode.Arrays;

/**
 * Created by vidyachitta on 6/12/17.
 */
public class ArrayPivot {
    static int arrayPivot(int[] nums){

       int low=0,high= nums.length-1,mid;

//        if(low == high-1)
//            return Math.max(nums[low],nums[high]);

        while (low<high-1){

            mid=low+(high-low)/2;
            //if()
            if(mid>0 && nums[mid]>nums[mid-1])
                low=mid;
            else
                high=mid;
        }
        return Math.max(nums[low],nums[high]);


    }
    static int rotatedPivot(int[] nums){
        int low=0,high=nums.length-1,mid;
        while(low<high){
            if (nums[low]<nums[high]) return low;
            mid=low+(high-low)/2;
            if (nums[mid]==nums[high])
                high--;
            else if (nums[mid]>nums[high]){
                    low=mid+1;
                }
                else high=mid;

        }
        if (low==high) return low;


        return -1;
    }

    static int search(int[]nums,int key){
        if (nums==null || nums.length ==0) return -1;
        int pivot= rotatedPivot(nums),low=0,high=nums.length-1,mid;

        //System.out.println(" low is: "+low+" nums[low]: "+nums[low]+"pivot is: "+pivot+" nums[pivot]: "+nums[pivot]+" high is: "+high+" nums[high]: "+nums[high]);

//        if (nums[pivot]==key)
//            return pivot;
//        else
            if (nums[pivot]<key && key<=nums[high])
            low=pivot+1;
        else if(pivot>0 && nums[low]<=key && key<=nums[pivot-1])
            high = pivot-1;
        high++;
        while (low<high-1){

            mid=low+(high-low)/2;
            if (key==nums[mid])
                return mid;
            else if (nums[mid]<=key)
                low=mid;
                else high =mid;
        }
        if (nums[low]==key) return low;
        else
return -1;
    }

    public static void main(String[] args) {
      //  int[] B={-1,2,4,6,8,9,10};
        int[] A= {5};
//        System.out.println(rotatedPivot(A));
//        for(int i:A)
//        System.out.println(search(A,i));
//        for (int j:B)
//        System.out.println(search(A,j));
        System.out.println(arrayPivot(A));
    }
}
