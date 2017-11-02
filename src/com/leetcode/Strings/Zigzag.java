package com.leetcode.Strings;
import java.util.*;

/**
 * Created by vidyachitta on 5/27/17.
 */
public class Zigzag {
    static String zigzagprint(String s,int nrow) {
        if (s == null || s.length() == 0 || nrow <1)
            return "";
        if (nrow == 1 || nrow>s.length())
            return s;
        int i =0,row=0,dir=1;

        int nzig = s.length()/(nrow*2-2);
        //char [][] zig = new char[nrow][2*nzig];
        ArrayList<ArrayList<Character>> zig = new ArrayList<ArrayList<Character>>();
        for (int rows =0; rows<nrow;rows++){
            ArrayList<Character> singleList = new ArrayList<Character>();
            zig.add(new ArrayList<Character>(singleList));
        }
        while(i < s.length()){
            ArrayList<Character>  list = zig.get(row);
            list.add(s.charAt(i));
            if (row == nrow-1)
                dir = -1;
            if (row ==0)
                dir = 1;
            row = row + dir;
            i++;
        }
        StringBuilder res= new StringBuilder() ;
        for (ArrayList<Character> arr : zig){
            for (char ch: arr){
                res.append(ch);
            }
        }
        return res.toString();
    }
    static String zigzagv2(String s, int nrow){
        if (s == null || s.length() == 0 || nrow <1)
            return "";
        if (nrow == 1 || nrow>s.length())
            return s;
        int len = s.length(),nzig= 2*nrow - 2;
        StringBuffer res = new StringBuffer();
        for (int row = 0;row<nrow;row++){
            System.out.println("row number"+row);
            int i =row;
            while (i < len){

                    System.out.println("corner"+s.charAt(i));
                    res.append(s.charAt(i));

                if (row != 0 && row != nrow-1 && i+((nrow-row)*2-2)<len){
                    System.out.println("inside"+s.charAt(i));
                    res.append(s.charAt(i+((nrow-row)*2-2)));
                }
                i+=nzig;
            }
        }
    return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(zigzagv2("PAYPALISHIRING",3));

    }
}
class Solution {
    public String convert(String s, int numRows) {
        int len = s.length();
        if (len <= numRows || numRows == 1) {
            return s;
        }

        int count = 0;
        int step = 2 * (numRows - 1);
        char[] result = new char[len];

        for (int i = 0; i < numRows; i++) {
            int interval = step - 2 * i;
            for (int j = i; j < len; j += step) {
                result[count++] = s.charAt(j);
                if (interval > 0 && interval < step && j + interval < len && count < len) {
                    result[count++] = s.charAt(j + interval);
                }
            }
        }

        return new String(result);
    }
}