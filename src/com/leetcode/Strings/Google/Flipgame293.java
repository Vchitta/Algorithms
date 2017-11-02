package com.leetcode.Strings.Google;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by vidyachitta on 6/14/17.
 */
public class Flipgame293 {
/*    You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner.

    Write a function to compute all possible states of the string after one valid move.

    For example, given s = "++++", after one move, it may become one of the following states:

            [
            "--++",
            "+--+",
            "++--"
            ]
    If there is no valid move, return an empty list [].*/



    static List<String> flipGame(String seq){
        List<String> statesNext = new ArrayList<String>();
        char[] chars=seq.toCharArray();

        for(int i=0;i<chars.length-1;i++){

            if("+".indexOf(chars[i])>=0 && "+".indexOf(chars[i+1])>=0){
                char[] res = seq.toCharArray();
                res[i]='-';
                res[i+1]='-';
                statesNext.add(new String(res));
            }
        }

        return statesNext;
    }
    static boolean checkRecord(String s) {
        int i=s.indexOf("A"),j=s.indexOf("LL");
           if ((i>=0 &&s.indexOf("A",i+1)>=0) ||(j>=0 && s.indexOf("LL",j+1) >=0))
            return false;
        return true;
    }
    static boolean allLower(String s){
        String lowerCase="abcdefghijklmnopqrstuvwxyz";
        int i=0;

        while (i<s.length()&& lowerCase.indexOf(s.charAt(i))>=0){
            i++;
            if(i==s.length())return true;
        }

        return false;
    }
    static boolean allUpper(String s){
        String upperCase="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int i=0;

        while (i<s.length()&& upperCase.indexOf(s.charAt(i))>=0){
            i++;
            if(i==s.length())return true;
        }

        return false;
    }
    static boolean detectCapital(String s){
        boolean res=true;
        String lowerCase="abcdefghijklmnopqrstuvwxyz";
        String upperCase="ABCDEFGHIJKLMNOPQRSTUVWXYZ";

            if (s.length()<1) return false;
            else if (s.length()==1) return true;
                else if(upperCase.indexOf(s.charAt(0))>=0 ){
                    if( s.length()>2){
                        if (lowerCase.indexOf(s.charAt(1))>=0)
                            res=allLower(s.substring(2));
                        else res=allUpper(s.substring(2));
                    }

                    }else
                        res=allLower(s.substring(1));

        return res;
    }

    public static void main(String[] args) {
        //System.out.println(Arrays.toString(flipGame("++++").toArray()));
       // System.out.println(reversev2(""));
        // System.out.println(checkRecord("PPPAPPLPLLPPPLL"));
        System.out.println(detectCapital("US"));
    }
}
/*  Stack<Integer> intStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder cur = new StringBuilder();
        int k = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + ch - '0';
            } else if ( ch == '[') {
                intStack.push(k);
                strStack.push(cur);
                cur = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                StringBuilder tmp = cur;
                cur = strStack.pop();
                for (k = intStack.pop(); k > 0; --k) cur.append(tmp);
            } else cur.append(ch);
        }
        return cur.toString();
*/