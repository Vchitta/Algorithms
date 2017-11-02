package com.Interviews.Google;

import java.util.Arrays;

/**
 * Created by vidyachitta on 6/18/17.
 */
public class First {

//     static char smallestChar(String s) {
//        char first= s.charAt(0);
//        for (int i = 1; i < s.length(); ++i)
//            if (s.charAt(i) < first)
//                first = s.charAt(i);
//        return first;
//    }

    static int smallestCharFreq(String s){

        int count = 1;
        char minChar = s.charAt(0);

        for (int i = 1; i < s.length(); ++i){
            if (s.charAt(i) < minChar){
                minChar = s.charAt(i);
                count=1;
            }
            else if(s.charAt(i) == minChar)
                count++;
        }

        return count;
    }

//    static int frequency(char ch,String s){
//         int i=0,count=0;
//         while (s.indexOf(ch,i)>=1){
//             count++;
//             i=s.indexOf(ch,i)+1;
//         }
//         return count;
//    }

   /* public static int[] solution(String A, String B) {
        String [] arrA= A.split(" ");
        String [] arrB= B.split(" ");
        int[] countA=new int[arrA.length];
        int[] C = new int[arrB.length];
        int index=0;

        // write your code in Java SE 8
        if(A.isEmpty())
            return C;
        if(B.isEmpty())
            return null;

        for (String s :arrA) {
            countA[index++]=smallestCharFreq(s);
        }

        for(int i=0;i<arrB.length;i++){
            String s=arrB[i];
            int minB=smallestCharFreq(s);
            C[i]=0;

            for (int j=0;j<arrA.length;j++){
                if(minB>countA[j]){
                    C[i]++;
                }
            }
        }
        return C;
*/


 //   }
    static int[] sol2(String A, String B){
        String [] arrA= A.split(" ");
        String [] arrB= B.split(" ");
        int[] countA=new int[arrA.length];
        int[] C = new int[arrB.length];
        int index=0;

        // write your code in Java SE 8
        if(A.isEmpty())
            return C;
        if(B.isEmpty())
            return null;

        for (String s :arrA) {
            countA[index++]=smallestCharFreq(s);
        }
        Arrays.sort(countA);
        for(int i=0;i<arrB.length;i++){
            String s=arrB[i];
            int minB=smallestCharFreq(s);
            C[i]=0;

            int pos =Arrays.binarySearch(countA,minB);
            if(pos<0){
                C[i]=-(pos+1);
            }else {
                int k;
                for( k=pos-1; k>0&&countA[pos] == countA[k];k--);
                C[i]=k+1;
            }
        }
        return C;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sol2("aab bcd nddd mmsna eefg aab bcd nddd mmsna eefg aab bcd nddd mmsna eefg", "abc aabc")));
        int a[]={1,1,4,3,1,5,1};

    }
}
