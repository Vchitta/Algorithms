package com.leetcode.Strings.Google;

/**
 * Created by vidyachitta on 6/16/17.
 */
public class EditDistance {

    static int minDistance(String s1,String s2){
        int len1 =s1.length(),len2=s2.length(),count=0;
//        for (int i=0,j=0;i<len1 ||j<len2;j++,i++){
//           // System.out.println(len1+" "+i+" "+len2+" "+j);
//
//        }

//        if(len1>0 && len2>0){
//            if(s1.charAt(len1-1)==s2.charAt(len2-1))
//            {
//                if(len1>1 &&len2>1){
//                    int a = Countonlydelete(s1.substring(0,len1-1),s2.substring(0,len2-1));
//                    return a;}
//                else {// where "a" and "mvma" or "mvma" and "a"
//                    if(len1==1) //where "e" and "kjjjza"
//                    return 1+len2;
//                    else return 1+len1;
//                }
//            }
//            else
//            {
//                if(len1>1 &&len2>1){
//                    int d=Countonlydelete(s1.substring(0,len1-1),s2.substring(0,len2));
//
//                    int c = Countonlydelete(s1.substring(0,len1),s2.substring(0,len2-1));
//                    return 1+Math.min(c,d);}
//                else {
//
//                    if(len1==1) //where "e" and "kjjjza"
//                    return 1+len2;
//                    else return 1+len1;
//                }
//            }
//        }else {
//            //len1<=0 or len2<=0
//            return 0;
//        }
//        if(s1.indexOf(s2)>=0)
//            return len1-len2;
//        if(s2.indexOf(s1)>=0)
//            return len2-len1;
        if(len1>1 && len2>1){
            if(s1.charAt(len1-1)==s2.charAt(len2-1)){
                int a = minDistance(s1.substring(0,len1-1),s2.substring(0,len2-1));
                return a;
            }
            else {
                int d=minDistance(s1.substring(0,len1-1),s2.substring(0,len2));

                int c = minDistance(s1.substring(0,len1),s2.substring(0,len2-1));
                return 1+Math.min(c,d);}
            }
            else if (len1==1 ||len2==1){// where "a" and "mvma" or "mvma" and "a"

                    if(len1==1){ //where "e" and "kjjjza"
                        if(s1.charAt(len1-1)==s2.charAt(len2-1)) len2=-2;
                            return 1+len2;}
                    else {
                        if(s1.charAt(len1-1)==s2.charAt(len2-1)) len1-=2;
                        return 1+len1;}
        }else { if(len1==0)//len1==0 or len2==0
                return len2;
                else return len1;
            }
    }
    public static void main(String[] args) {
        System.out.println(minDistance("dinitrophenylhydrazine",
                "benzalphenylhydrazone"));
    }
}
