package com.leetcode.Strings;

import java.util.Arrays;

/**
 * Created by vidyachitta on 6/3/17.
 */
public class LongestPalindromeSubstring {
    static String LPS(String word){
        int len= word.length(),i,curr_len,max_len=0,palindrome_start=0;//i=0,j=0,set=0;
        int[][] comp = new int[len][len];
        curr_len=0;
        for( i=0;i<len-curr_len;i++){
            comp[i][i]=1;
        }
        curr_len++;
        for ( i=0;i<len-curr_len;i++){
            if (word.charAt(i)==word.charAt(i+1)){
                comp[curr_len+1][curr_len]=1;
                max_len = 2;
                palindrome_start=curr_len;
            }
            else comp[curr_len+1][curr_len]=0;

        }

        for (curr_len = 2;curr_len<=len;curr_len++){
            for ( i=0;i<len-curr_len;i++){
                if((word.charAt(i)==word.charAt(i+curr_len)) && (comp[i+1][i+curr_len-1]==1)){
                    comp[i][i+curr_len]=1;
//                    int checki=i,checkj=i+curr_len;
//                    while (checkj-checki>0 && comp[++checki][--checkj]==1 );
//                    if (checki==checkj){
                        max_len=curr_len;
                        palindrome_start=i;
//                    }
                }
                else comp[i][i+curr_len]=0;
            }

        }

       // System.out.println(Arrays.toString(Arrays.toString(comp)));

    //return new String(Arrays.copyOfRange(word.toCharArray(),palindrome_start,palindrome_start+max_len+1));
    return word.substring(palindrome_start,palindrome_start+max_len+1) ;
//return s[1:3]

    }

    public static void main(String[] args) {
        System.out.println( LPS("malayalamnbmnbmn"));
    }

}
