package com.leetcode.Strings;
import java.util.Arrays;
import java.lang.StringBuilder;


/**
 * Created by vidyachitta on 5/22/17.
 */

//Given a string that consists of only uppercase English letters, you can replace any letter in the string with another letter
// at most k times. Find the length of a longest substring containing all repeating letters
// you can get after performing the above operations.
//Note:
//Both the string's length and k will not exceed 104.









public class LongRepeatingSS424 {

    public static int characterReplacement(String s, int k) {
        if (s == null)
            return 0;
        if (k>s.length())
            return s.length();

        return 1;
    }
    public static int[] InttoList(int num) {


        String temp = Integer.toString(num);
        int[] newGuess = new int[temp.length()];
        for (int i = 0; i < temp.length(); i++)
        {
            newGuess[i] = temp.charAt(i) - '0';
        }
        return newGuess;

    }

    public static void main(String[] args) {
        //System.out.println(characterReplacement("ABBA",1));
        //System.out.println(Arrays.toString(InttoList(123)));
    }
}
