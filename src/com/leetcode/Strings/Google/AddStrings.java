package com.leetcode.Strings.Google;

/**
 * Created by vidyachitta on 6/15/17.
 */
public class AddStrings {
    static int getInteger(String s){
        for(char ch:s.toCharArray()){

        }
        return 0;
    }
    static String addStrings(String num1, String num2){
        if (num1.isEmpty()&&num2.isEmpty())return "";
        else if (num1.isEmpty()) return num2;
        else if (num2.isEmpty()) return num1;

        int  i=num1.length()-1,j=num2.length()-1,carry=0,d1,d2,temp;
        String res="";

        while (i>=0 || j>=0){
            if(i>=0 && j>=0){
                d1 = num1.charAt(i)-'0';
                d2 = num2.charAt(j)-'0';
            }
            else if(i>=0 && j<0){
                d1 = num1.charAt(i)-'0';
                d2 = 0;
            }
            else
                //if (j>=0 && i<0)
                {
                d1 = 0;
                d2 = num2.charAt(j)-'0';
            }

            temp=d1+d2+carry;

            if(!(i<=0&&j<=0) && temp>9){
                 carry=temp/10;
                temp=temp%10;
            }else carry=0;

            res=temp+res;
            i--;j--;
    }
        return res;
    }
    static String add(String num1, String num2) {
        StringBuilder sum = new StringBuilder();
        int carry = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry == 1; i--, j--) {
            int a = 0, b = 0;
            if (i >= 0) {
                a = num1.charAt(i) - '0';
            }
            if (j >= 0) {
                b = num2.charAt(j) - '0';
            }
            if (a + b +carry> 9) {
                sum.append(a + b - 10 + carry);
                carry = 1;
            } else {
                sum.append(a + b + carry );
                carry = 0;
            }
        }
        sum.reverse();
        return sum.toString();
    }

    public static void main(String[] args) {
        System.out.println(addStrings("99","9"));
        System.out.println(8+99);
    }
}
