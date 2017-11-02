package com.leetcode.Strings;

import java.util.Arrays;

/**
 * Created by vidyachitta on 6/4/17.
 */
public class LongestcommonSubstring {
    static String LCS(String str1,String str2){
        int n1=str1.length(),n2=str2.length(),max=Integer.MIN_VALUE,maxi=max,maxj=max;
        String res="";
        int[][] comp = new int[n1+1][n2+1];

        for (int i=0;i<=n1;i++){
            comp[i][0]=0;
        }
        for(int j=0;j<=n2;j++){
            comp[0][j]=0;
        }
        for ( int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                comp[i][j] = comp[i-1][j-1]+1;
                if (comp[i][j]>max){
                    max=comp[i][j];
                    maxi=i;
                    maxj =j;
                }

                }
            }
        }
        System.out.println(Arrays.deepToString(comp));


        while (comp[maxi][maxj]>0){

            System.out.println(maxi+" "+maxj+" "+comp[maxi][maxj]);
                res=str1.charAt(maxi-1)+res;
                maxi--;maxj--;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(LCS("CLCL" , "LCLC" ));
    }
}
