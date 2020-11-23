package com.leetcode.Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by vidyachitta on 6/17/17.
 */
public class threesumSmaller {
    /*Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.

For example, given nums = [-2, 0, 1, 3], and target = 2.

Return 2. Because there are two triplets which sums are less than 2:

[-2, 0, 1]
[-2, 0, 3]
    * */
    static int checkPair(int[]nums,int end,int target){
        int low=0,count=0;
        while (low<end){
            if(nums[low]+nums[end]< target) {
                count += end - low;
                low++;
            }
            else end--;
        }

        return count;
    }
    static int sum(int[]nums,int target){

        int count=0;
        Arrays.sort(nums);
        for(int i=2;i< nums.length;i++){
            count+=checkPair(nums,i-1,target-nums[i]);
            }

        return count;
    }
    static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
    	Map<Integer,Integer> map = new HashMap<>();
    	
    	for(int i=0;i<nums.length;i++){
    		if(map.containsKey(target - nums[i] )){
    			result[0] = map.get(target - nums[i]);
    			result[1] =i;
    		}
    		map.put(nums[i], i);
    	}
		return result;
        
     }

    public static void main(String[] args) {
        int[] A ={1,-1,2,0,3,-2};
        System.out.println(sum(A,2));
    }
}
