package com.leetcode.Strings.Google;

import java.util.Arrays;

/**
 * Created by vidyachitta on 6/16/17.
 */

class Solution{
    int level;
    public class tree{
        int val;
        tree left;
        tree right;
        tree(int i){
            val=i;
        }
    }

    String matches(int n){
        if(n==1) return "1";
        level= (int)(Math.log(n)/Math.log(2));
        tree root=new tree(1);
        dfs(root,1);
        return peek(root);
    }
    String peek(tree root){
        if(root.left==null && root.right==null)
            return ""+root.val;
        else return "("+peek(root.left)+","+peek(root.right)+")";
    }

    void dfs(tree root,int n){
        if( n>level) return;
        root.left=new tree(root.val);
        root.right=new tree(((int)(Math.pow(2,n)))+1-root.left.val);
        dfs(root.left,n+1);
        dfs(root.right,n+1);
    }

        }
public class contestMatches {
    static String matches(int n){
        String[] arr = new String[n];
        for (int i=1;i<=n;i++)
            arr[i-1]=String.valueOf(i);

       // System.out.println(Arrays.toString(arr));
       // int low=0,high=arr.length-1;

        while (arr.length>1){
            int low=0,high=arr.length-1;
            String[] temp=new String[(high+1)/2];
            while (low<high){
                temp[low]="("+String.join(",",arr[low++],arr[high--])+")";
            }
            //arr=new String[];
            arr=temp;
            System.out.println(Arrays.toString(arr));
        }
        return arr[0];
    }

    public static void main(String[] args) {
        //System.out.println(matches(8));
        Solution sol=new Solution();
        System.out.println(sol.matches(8));
    }
}
