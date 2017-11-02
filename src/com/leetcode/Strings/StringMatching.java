package com.leetcode.Strings;
import java.lang.Math;
import java.util.*;

/**
 * Created by vidyachitta on 5/31/17.
 */
public class StringMatching {

    static int  Bruteforce(String text, String pattern){
        int n = text.length(),m=pattern.length(),j=0;
        for(int i =0; i< m-n+1;i++){
             j =0;
             while (j<m){
                 if (text.charAt(i+j)==pattern.charAt(j))
                 j++;
                 else
                     break;
             }
             if (j==m)
                 return 1;
        }
        return 0;
    }
    static int hash(int[] arr){
        int len=arr.length-1,i=len;
        int hash=0;
        while(i>=0 ){
            hash +=(int) Math.pow(10,len-i)*arr[i--];

        }
        return hash;
    }
    static int robinkarp(int[] T,int[] P){
        int n = T.length,m=P.length;
  //      int[] tm = new int[m];
//        for (int i=0;i<m;i++){
//            tm[i]=T[i];
//        }
        int hashp = hash(P),hasht = hash(Arrays.copyOfRange(T,0,m));


        for( int i =0; i< n-m+1;i++) {
            if (hashp==hasht){
                return 1;}
            if (i+m<n)
            hasht= 10*(hasht- (int)Math.pow(10,m-1)* T[i]) + T[i+m];
        }
        return 0;
    }
    static int[] prefixarray(String arr){
        int i=1,j=0;
        int[] F = new int[arr.length()];
        F[0]=0;
        while (i<arr.length()){
            if (arr.charAt(i)==arr.charAt(j)){
                F[i]=F[i-1]+1;
                i++;
                j++;
            }
            else{ if (j>0){
                    j=F[j-1];}
            else{
                F[i]=0;
                i++;}}
        }
        return F;

    }
    static int kmp(String T,String P){

        int n = T.length(),m=P.length(),i=0,j=0;
        int[] F = prefixarray(P);

        while (i<n){
            if( T.charAt(i)==P.charAt(j)){
                if (j==m-1)
                    return 1;
                else
                    i++;
                    j++;}

            else {
                if (j > 0)
                    j = F[j - 1];

                else{ j = 0; i++;}
            }
        }
        return 0;

    }
    static int boycemoore(String text, String pattern){
        int len=pattern.length(),j =len-1,block=j,it=j;
        HashMap<Character,Integer> hm=new HashMap<Character,Integer>();
        for(int i =0; i< len;i++){
            char ch = pattern.charAt(i);
            if( i == len-1)
                hm.put(ch,len);
            else
                hm.put(ch,len-i-1);
            //else hm.put(ch,hm.get(ch)+1);
        }
        while( j< text.length()){
            if (pattern.charAt(it)==text.charAt(j)){
                j--;
                it--;
                if (it==-1){
                    return 1;
                }
            }
            else {
                j = block+hm.get(text.charAt(block));
                block = j;
                it=len-1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int [] text = {1,2,3,5,6,8,9,9} ;
        int [] pattern ={8,9,9};
        //System.out.println(robinkarp(text,pattern));
        //System.out.println(kmp("abxabcabcaby","abcaby"));
        System.out.println(boycemoore("abxabcabcaby","abcaby"));
        //System.out.println(hash(pattern));
    }
}
