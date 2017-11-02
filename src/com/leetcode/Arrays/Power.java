package com.leetcode.Arrays;

/**
 * Created by vidyachitta on 6/16/17.
 */
public class Power {
    static int powerR(int a,int n ){

        if(n==0) return 1;
        else {
            int temp=powerR(a,n/2);
            if((n%2)==0) return temp*temp; //to find if it's even
            else  return a*temp*temp;
        }
    }

    static int powerI(int x, int y){
        int res=1;

        for (;y>0;y=y/2){
            if((y & 1)==1)
                res = res*x;
            if (y>0) x = x*x;  // Change x to x^2
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(powerI(2,8));
    }
}
