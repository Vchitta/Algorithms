package com.leetcode.Strings;

import java.util.Arrays;

/**
 * Created by vidyachitta on 6/5/17.
 */
public class LongestcommonSubsequnce {
/*
* subsequence is different from substring, this is subsequence
*/
static String LCSS(String str1,String str2){
    int n1=str1.length(),n2=str2.length();
    int[][] comp =new int[n1][n2];
    int[][] track =new int[n1][n2];

    for (int i=0;i<n1;i++){
        for (int j =0;j<n2;j++){
            if (str1.charAt(i)==str2.charAt(j)){
                if (i==0||j==0){
                    comp[i][j]=1;

                }
                else{
                    comp[i][j]=1+comp[i-1][j-1];
                }
                track[i][j]=0;

            }
            else {
                //comp[i][j]= Math.max(comp[i-1][j],comp[i][j-1]);
                if (i==0 && j==0){
                    comp[i][j]=0;
                    track[i][j]=2;}
                else {

                    if (i==0 && j>0){
                    comp[i][j]=comp[i][j-1];
                    track[i][j]=1;
                }else if (i>0 && j==0){
                    comp[i][j]=comp[i-1][j];
                    track[i][j]=2;
                }else {
                    if (comp[i-1][j]>=comp[i][j-1]) {
                        comp[i][j]=comp[i-1][j];
                        track[i][j]=2;
                    }else {
                        comp[i][j]=comp[i][j-1];
                        track[i][j]=1;
                    }
                }
            }}
        }
    }

    for (int i=0;i<n1;i++){
        for (int j =0;j<n2;j++){

        }
    }
    System.out.println(Arrays.deepToString(comp));
    System.out.println(Arrays.deepToString(track));

    return "";
}


    public static void main(String[] args) {
        System.out.println(LCSS("zAdmc","Abdgc"));;
    }
}
