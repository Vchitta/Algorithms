package com.Practice;

/**
 * Created by vidyachitta on 5/25/17.
 */
public class Strungs {
    public static void main(String[] args) {
        String res;
        String s = "Rohan is a boy.";
        String replace="is";
        int i = s.indexOf(replace);
        String change = "was";
        System.out.println(s);
        res = s.substring(0,i)+ change + s.substring(i+replace.length());
        System.out.println(res);
        String resCaps = res.toUpperCase();
        System.out.println(resCaps);

        String resrep = "helloooo".replace("ooo","s");
        System.out.println(resrep.startsWith(" he".trim()));
        for (char c:res.toCharArray()){
            if (c == ' ' ){
                System.out.print(" #");
            }
            else
            System.out.print(c);
        }
        System.out.println();
        System.out.println(resrep);
        resrep=res.replace("Boy","Girl");
        System.out.println(resrep);
        i = res.indexOf("boy");
        System.out.println(res.regionMatches(i,resCaps,i,3));
        String[] pie = res.split(" ");
        for (String str: pie){
            System.out.print("*"+str);
        }

    }
}
