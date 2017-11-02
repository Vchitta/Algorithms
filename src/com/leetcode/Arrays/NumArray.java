package com.leetcode.Arrays;

/**
 * Created by vidyachitta on 7/12/17.
 */
public class NumArray {
   /* Leetcode 307. Range Sum Query - Mutable
   Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

The update(i, val) function modifies nums by updating the element at index i to val.*/
    int[] numbers;

    public NumArray(int[] nums) {

        numbers=new int[nums.length];
        for (int i =0;i<nums.length;i++){
            update(i,nums[i]);
        }

    }

    public void update(int i, int val) {
        int oldval= i > 0 ? numbers[i]-numbers[i-1] : numbers[0];
        int diff =  val - oldval;
        for (int j=i;j<numbers.length;j++){
            numbers[j] += diff;
        }

    }

    public int sumRange(int i, int j) {
        return i > 0 ? numbers[j] - numbers[i-1] : numbers[j];

    }
}

 class NumArrayImm {

    int[] numbers;

    public NumArrayImm(int[] nums) {

        numbers=new int[nums.length];
        if(nums.length>0)numbers[0] = nums[0];
        for (int i =1;i<nums.length;i++){
            numbers[i]=numbers[i-1]+nums[i];
        }

    }
    public int sumRange(int i, int j) {
        return i > 0 ? numbers[j] - numbers[i-1] : numbers[j];
    }
}

class Main{
    public static void main(String[] args) {
        int[] A={3,5,8,5,7,9};
        NumArray nm = new NumArray(A);
        System.out.println(nm.sumRange(1,3));
        System.out.println(nm.sumRange(0,3));

        nm.update(3,-5);
        System.out.println(nm.sumRange(1,3));
        System.out.println(nm.sumRange(0,3));
    }
}
