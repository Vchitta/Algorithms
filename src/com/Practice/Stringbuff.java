package com.Practice;

/**
 * Created by vidyachitta on 5/25/17.
 */
public class Stringbuff {

    static String reversesb(String s){
        StringBuffer sb = new StringBuffer(s);
        s = sb.reverse().toString();
        return s;

    }
    static String reversestr(String s){

        char[] let = s.toCharArray();
        String rev="";
        for (char ch:let){
            rev = ch + rev;
        }
        return rev;

    }


    public static void main(String[] args) {
        System.out.println(reversestr("what the hell"));



    }

}
