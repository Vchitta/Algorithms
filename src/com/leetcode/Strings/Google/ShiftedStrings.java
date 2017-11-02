package com.leetcode.Strings.Google;

import java.util.*;

/**
 * Created by vidyachitta on 6/16/17.
 */
public class ShiftedStrings {

    public static List<List<String>> groupStrings(String[] strings) {

        Map<String,Integer> map=new HashMap<String,Integer>();
       // String[] shifted=new String[strings.length];
        int shiftindex=0,offset;
        List<List<String>> result = new ArrayList<>();

        for (int i=0;i<strings.length;i++){
            String str=strings[i];
            /*while (!(str.indexOf('a')==0) ){


                for (char ch:str.toCharArray())
                    sb.append(Character.toString((char) (((ch - 'a' + offset) % 26) + 'a')));


                    str=sb.toString();
                }*/
            //making all strings project to 'a' at starting

            offset=str.charAt(0)-'a';
            StringBuilder sb = new StringBuilder();
            for (char ch:str.toCharArray()){
                if(ch-offset<'a')
                    ch+=26;
                sb.append(Character.toString((char) (((ch - offset-'a') % 26)+'a') ));
            }
            str=sb.toString();

            if(map.containsKey(str)){
                result.get(map.get(str)).add(strings[i]);
            }else{
                List<String > list= new ArrayList<String>(50);
                list.add(strings[i]);
                result.add(shiftindex,list);
                map.put(str,shiftindex);
                shiftindex++;
            }
          //  shifted[i]=str;
        }

        return result;
    }
   /* public static List<List<String>> groupStringsv2(String[] strings) {
        int offset;
        for(String str:strings){
            String pattern="(";
            for (int i=0;i<str.length();i++){

                if (i==0)
                    offset=str.charAt(i)-'a';
                else
                 offset=str.charAt(i)-str.charAt(i-1);

                pattern+=offset+"-";
            }
            pattern=pattern.substring(0,pattern.length()-1);
        }

    }*/


        public static void main(String[] args) {
        String[] arr={"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
//        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.deepToString(groupStrings(arr).toArray()));
    }
}
