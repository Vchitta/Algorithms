package com.leetcode.Strings.Google;

/**
 * Created by vidyachitta on 6/24/17.
 */
public class NumMatrix {
    int[][] ele;
    public NumMatrix(int[][] matrix) {
       // ele=new int[matrix.length][matrix[0].length];
        ele=matrix;
    }

    public void update(int row, int col, int val) {
        ele[row][col]=val;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum=0;
        for (int i=row1;i<=row2;i++)
            for (int j=col1;j<=col2;j++)
                sum+=ele[i][j];
        return sum;
    }
}

class NumArray {
    int[] array;
    int[] arraySum;

    public NumArray(int[] nums) {
        this.array=nums;
        arraySum=new int[nums.length];
        arraySum[0]=nums[0];
        for (int i=1;i<arraySum.length;i++)
            arraySum[i]=arraySum[i-1]+nums[i];
    }

    public void update(int i, int val) {
        int delta=array[i]-val;
        array[i]=val;
        while (i<array.length){
            arraySum[i]=arraySum[i]+delta;
        }

    }

    public int sumRange(int i, int j) {
        return arraySum[j]-arraySum[i]+array[i];

    }
}