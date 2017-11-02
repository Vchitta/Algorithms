package com.leetcode.Strings.Google;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by vidyachitta on 6/18/17.
 */
//* Definition for an interval.
class Interval{
    int start;
    int end;
    Interval(){start=0;end=0;}
    Interval(int s,int e){start=s;end=e;}

    @Override
    public String toString() {
return "["+start+","+end+"]";
    }
}
public class InsertInterval {

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {

//        int i=0;
//        while (i<intervals.size()){
//            Interval interval=intervals.get(i++);
//            if (interval.end>=newInterval.start){
//
//            }
//
//
//        }




//        boolean start=false,end =false,place=false,replace=false;
//        int sindex=0,eindex=0,pindex=intervals.size(),rindex=0,re=0;
//        for(int i=0;i<intervals.size();i++){
//            Interval interval=intervals.get(i);
//
//            if((!start) && (!place)&& newInterval.start<=interval.start){
//                place=true;
//                pindex=i;
//            }
//            if(!start && interval.start<=newInterval.start && newInterval.start<=interval.end){
//                 start = true;
//                sindex = i;
//            }
//            if(!start && newInterval.start<=interval.start && interval.end<=newInterval.end){
//                replace=true;
//                rindex=i;
//                re++;
//            }
//            if(!end && interval.start<=newInterval.end && newInterval.end<=interval.end){
//                end=true;
//                eindex=i;
//                break;
//            }
//        }
//        if(replace){
//            for (int i=re;i>0;i--)
//                intervals.remove(rindex-re+1);
//            intervals.add(rindex-re+1,newInterval);
//        }
//        else if(start && end){
//
//            intervals.add(sindex,new Interval(intervals.get(sindex).start,intervals.get(eindex).end));
//
//            for (int i=sindex+1;i<=eindex+1;i++)
//                intervals.remove(sindex+1);
//
//        }else if(start){
//
//            intervals.add(sindex,new Interval(intervals.get(sindex).start,newInterval.end));
//            intervals.remove(sindex+1);
//
//        }else if(end){
//            intervals.add(sindex,new Interval(newInterval.start,intervals.get(eindex).end));
//            intervals.remove(eindex+1);
//
//        }else intervals.add(pindex,newInterval);
//
//        return intervals;
        List<Interval> result = new LinkedList<>();
        int i = 0;
        // add all the intervals ending before newInterval starts
        while (i < intervals.size() && intervals.get(i).end < newInterval.start)
            result.add(intervals.get(i++));
        // merge all overlapping intervals to one considering newInterval
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            newInterval = new Interval( // we could mutate newInterval here also
                    Math.min(newInterval.start, intervals.get(i).start),
                    Math.max(newInterval.end, intervals.get(i).end));
            i++;
        }
        result.add(newInterval); // add the union of intervals we got
        // add all the rest
        while (i < intervals.size()) result.add(intervals.get(i++));
        return result;


    }


}
 class MaximumDistance {
    public int maxDistance(List<List<Integer>> arrays) {
        List<Integer> array=arrays.get(0);
        int max=array.get(array.size()-1);
        int min=array.get(0);
        int value=Integer.MIN_VALUE;

        for (int i=1;i<arrays.size();i++){
            array=arrays.get(i);

            value = Math.max(value,Math.abs(array.get(0)-max));
            value= Math.max(value,Math.abs(array.get(array.size()-1)-min));
            min=Math.min(min,array.get(0));
            max=Math.max(max,array.get(array.size()-1));


            
//            for (int j=0;j<arrays.size();j++){
//                if (j!=i){
//                List<Integer> array=arrays.get(j);
//                int diff=Math.abs(arr.get(0)-array.get(array.size()-1));
//                if (diff>max){
//                    max=diff;
//                }
//            }
//
//            }


        }
        return value;
    }
}
class Solution1{
    public static void main(String[] args) {
        Interval interval1 = new Interval(1,2);
        Interval interval2 = new Interval(3,5);
        Interval interval = new Interval(9,11);
        Integer[] integers =new Integer[]{1,2,3};
        List<Interval> list=new ArrayList<>();
        list.add(interval1);
        list.add(interval2);
        InsertInterval ins=new InsertInterval();
       // System.out.println(Arrays.toString(ins.insert(list,interval2).toArray()));
        MaximumDistance max=new MaximumDistance();
        List<Integer> l1=Arrays.asList(1,2,3);
        List<Integer> l2=Arrays.asList(4,5);
        List<List<Integer>> lists=new ArrayList<List<Integer>>();
        lists.add(l1);lists.add(l2);
        System.out.println(max.maxDistance(lists));



    }
}
