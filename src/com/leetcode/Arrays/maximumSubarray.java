package com.leetcode.Arrays;

/**
 * Created by vidyachitta on 6/25/17.
 */
public class maximumSubarray {

    public static int maxSubArray(int[] nums) {

        int maxSum=nums[0],prevsum=nums[0];

        for (int i=1;i<nums.length;i++){

            if (maxSum+nums[i]>nums[i])
            maxSum=maxSum+nums[i];
            else maxSum=nums[i];
                //maxSum=Math.max(maxSum+nums[i],nums[i]);

            if (maxSum>prevsum)
            prevsum=maxSum;
               // prevsum=Math.max(prevsum,maxSum);

        }
        return prevsum;
    }

    public static void main(String[] args) {
        int[] A={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(A));
    }

}
