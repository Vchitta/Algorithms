package com.Interviews.Google;

import java.util.Arrays;

/**
 * Created by vidyachitta on 6/18/17.
 */
public class Sample {
    public static String solution(String S, int K) {
        // write your code in Java SE 8
        String res="";
        S=S.replace("-","");
        S=S.toUpperCase();
        System.out.println(S);
        char[] arr=S.toCharArray();
        for(int i=S.length();i>0;i-=K){
            if(i>K)
            res="-"+new String(Arrays.copyOfRange(arr,i-K,i))+res;
            else {
                res=new String(Arrays.copyOfRange(arr,0,i))+res;
                break;
            }
        }

    return res;
    }

    static String solutuon2(String s, int k){
      //  public String licenseKeyFormatting(String s, int k) {
            StringBuilder sb = new StringBuilder();
            for (int i = s.length() - 1; i >= 0; i--)
                if (s.charAt(i) != '-')
                    sb.append(sb.length() % (k + 1) == k ? '-' : "").append(s.charAt(i));
            return sb.reverse().toString().toUpperCase();
        }


    public static void main(String[] args) {
        System.out.println(solutuon2("2-4A0r7-4k",3));
    }
}
