package com.leetcode.Arrays;


import java.util.Arrays;

/**
 * Created by vidyachitta on 6/10/17.
 */
public class almostSum {
    static int[] almostsumzero(int[] nums){
        int len=nums.length,sum,minsum=Integer.MAX_VALUE,minindex1=Integer.MAX_VALUE,minindex2=Integer.MAX_VALUE;
        for (int i = len-1;i>=0;i--){

            for (int j = i-1;j>=0;j--){
                sum= nums[i]+nums[j];
                if (Math.abs(sum)<minsum){
                    minsum= Math.abs(sum);
                    minindex1=j;
                    minindex2=i;
                }
            }
        }
        int[] res= {minindex1,minindex2};
        return res;
    }
    static int[] almostsumzeroV1(int[] nums){
        Arrays.sort(nums);
        int[] res = new int[2];
        int resi=0,low=0,high=nums.length-1,temp,nclose=Integer.MAX_VALUE,pclose=Integer.MAX_VALUE,ip=0,jp=0,in=0,jn=0;
        while(low<high){
            temp=nums[low]+nums[high];
            if (temp>0){

                if (temp<Math.abs(pclose)){
                    pclose=temp;
                    ip=low;
                    jp=high;}
                high--;
            }
            else if (temp<0){
                if (temp<Math.abs(nclose)){
                    nclose=temp;
                    in=low;
                    jn=high;}
                low++;

            }else {
                res[1]=nums[low];
                res[0]=nums[high];
                return res;
            }
        }

        res[0]= (Math.abs(pclose)<Math.abs(nclose))?  nums[ip]: nums[in];
        res[1] = (Math.abs(pclose)<Math.abs(nclose))?  nums[jp]: nums[jn];
        return res;

    }

    public static void main(String[] args) {
        int[] A= {-83,83,1,60,-10,70,-80,1};

        int[] res=almostsumzeroV1(A);
        System.out.println(Arrays.toString(res));
    }
}
