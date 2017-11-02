package com.leetcode.Strings;

/**
 * Created by vidyachitta on 6/4/17.
 */
public class RemoveWhitespaces {
    static String Removespaces(String Sentence){
        /*StringBuffer sen=new StringBuffer(Sentence);
        int len=Sentence.length(),index=0;
        for (int i =0; i<len;i++){
            char ch =Sentence.charAt(i);
            if (!Character.isWhitespace(ch)){
                sen.setCharAt(index,ch);
                index++;
            }
        }
        return sen.substring(0,index)+".";*/
        return Sentence.replace(" ","");
    }
    // just use string.replace(" ","")

    public static void main(String[] args) {
        System.out.println(Removespaces("  hello this        is honey       who is that     .    "));
    }
}
