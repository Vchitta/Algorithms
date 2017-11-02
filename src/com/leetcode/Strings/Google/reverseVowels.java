package com.leetcode.Strings.Google;

/**
 * Created by vidyachitta on 6/14/17.
 */
public class reverseVowels {

    static boolean isConsonant(char ch){
        String Vowels="AEIOUaeiou";
        //return (Vowels.indexOf(ch)>=0) ? false:true;

        return Vowels.contains(Character.toString(ch));
    }
//   static String swap(String str,int a,int b){
//        if (!(a<=b)) {
//            a=a+b;
//            b=a-b;
//            a=a-b;
//        }
//        return str.substring(0,a)+str.charAt(b)+str.substring(a+1,b)+str.charAt(a)+str.substring(b+1);
//
//
//
//    }
    static String ReverseVowels(String str){
        int low=0,high=str.length()-1;
        char[] letters =str.toCharArray();
        while (low<high){
            while(low<high && isConsonant(letters[low])){
                low++;
            }
            while (low<high && isConsonant(letters[high])){
                high--;
            }

            char temp= letters[low];
            letters[low]=letters[high];
            letters[high]=temp;
                low++;high--;

        }


        return new String(letters) ;

    }
    static String reverse(String s){
        int i= s.length();
        char[] rev = new char[i];
        for(char ch:s.toCharArray()){
            rev[i-1]=ch;
            i--;
        }
        return new String(rev);
    }
    static String reverseWordsv2(String s){
        String[] words=s.split(" ");
        String res="";
        for(String word:words)
            res+=reverse(word)+".";
        if (res.length()>0) res=res.substring(0,res.length()-1);
        return res;
    }

    static String reverseWords(String str){
        int i=0;
        String res="";
        while (i<str.length()){
            int space=str.indexOf(" ",i);
            if(space>=0){
                res+=reverse(str.substring(i,space))+" ";
                i=space+1;
            }
            else break;
        }
        res+=reverse(str.substring(i));
        return res;
    }
    static String reverseK(String str,int k){
        int i=0;String rev="";
        boolean ifrev=true;
        char[] lett=str.toCharArray();
        while ( i+k<=str.length()){
           if(ifrev)
               rev  += reverse(str.substring(i, i + k));
           else rev += (str.substring(i, i + k));
           ifrev=!ifrev;
           i=i+k;

        }
        if(i<str.length()){
            if(ifrev)
                rev  += reverse(str.substring(i));
            else rev += (str.substring(i));
        }
        return rev;
    }
    public static void main(String[] args) {
        //System.out.println(swap("hello",1,4));
       // System.out.println(ReverseVowels("hello"));
       // System.out.println(reverseK("hellovidyabay",2));
        System.out.println(reverseWordsv2(" "));
    }
}
