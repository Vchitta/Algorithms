package com.leetcode.Strings.Google;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vidyachitta on 6/23/17.
 */
public class SubstringKdistinct {
    static int lengthOfLongestSubstringKDistinct(String s, int k) {
        int start=0,end,count=0,i=0,maxLen=0,len=0;
        Map<Character,Integer> map=new HashMap<>();
        char[] letters=s.toCharArray();
        while (i<letters.length) {
            if(count<k){
                if(map.containsKey(letters[i])){
                    map.put(letters[i],map.get(letters[i])+1);
                }
                else{
                    map.put(letters[i],1);
                    count++;
                }
                len=i+1-start;
                i++;

            }
            else {
                if(len>maxLen)
                    maxLen=len;
                while (map.get(letters[start])>0){
                    char ch = letters[start];
                    int freq=map.get(letters[start])-1;

                    start++;

                    if(freq==0) {
                        map.remove(ch);
                        count--;
                        break;
                    }
                    map.put(ch,freq);

                }
            }
        }
    return maxLen;
    }
    static int solution(String s, int k){
        Map<Character,Integer> map=new HashMap<>();
        char[] letters=s.toCharArray();
        int start=0,count=0,i=0,maxLen=0,len=0;

        while (i<s.length()){
            char ch=s.charAt(i) ;
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)+1);
            }
            else{
                map.put(ch,1);
                count++;
            }
            //map.put(ch,map.getOrDefault(ch,0)+1);
            while (count>k){
                char c=s.charAt(start);

                if(map.get(c)==1){
                    map.remove(c);
                    count--;
                }else map.put(c,map.get(c)-1);
                start++;
            }
            if (len<i-start+1)
                len=i-start+1;
            i++;

        }
        return len;
    }
    public static void main(String[] args) {
        System.out.println(solution("eceba",2));
    }

}
