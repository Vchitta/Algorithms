package com.leetcode.Strings.Google;

import java.util.Stack;

/**
 * Created by vidyachitta on 6/15/17.
 */
public class DecodeString {
    /*
    Examples:

s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
     */

    static String decode(String s){
        /*
        only works for cases like test case-1; did not see next cases
         */
        int i=0,len=s.length(),occ=0;
        StringBuilder decoded_string=new StringBuilder();
        StringBuilder temp=new StringBuilder();

        while (i<len){
            char ch=s.charAt(i);
            if(Character.isDigit(ch)){
                occ=occ*10+(ch-'0');
            }
            else if(ch=='['){
                 temp=new StringBuilder();
            }
            else if(ch==']'){
                for (;occ>0;occ--)
                    decoded_string.append(temp);
            }
            else temp.append(ch);
            i++;
        }
    return decoded_string.toString();
    }

    static String decodev2(String s){
        int i=0,len=s.length(),occ=0;
        StringBuilder decoded_string=new StringBuilder();
        StringBuilder temp=new StringBuilder();
        Stack<Integer> integerStack= new Stack<Integer>();
        Stack<StringBuilder> stringBuilderStack= new Stack<StringBuilder>();


        while (i<len){
            char ch=s.charAt(i);

            if(Character.isDigit(ch)){
                occ=occ*10+(ch-'0');
            }else if(ch=='['){
                integerStack.push(occ);
                stringBuilderStack.push(decoded_string);
                decoded_string=new StringBuilder();
                occ=0;
            }else if(ch==']'){
                temp=decoded_string;
                decoded_string=stringBuilderStack.pop();
                for (occ=integerStack.pop();occ>0;occ--)
                    decoded_string.append(temp);
            }else decoded_string.append(ch);

            i++;
        }
    return decoded_string.toString();
    }

    static int possibleEncodings(int[] digits){


        return 1;
    }
    public static void main(String[] args) {
        System.out.println(decodev2("3[az2[cz2[d]]e]f"));
    }
}
