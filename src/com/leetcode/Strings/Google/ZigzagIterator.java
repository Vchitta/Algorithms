package com.leetcode.Strings.Google;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by vidyachitta on 6/18/17.
 */
public class ZigzagIterator {

    Iterator<Integer> itf;
    Iterator<Integer> its;
    boolean f;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        itf = v1.iterator();
        its = v2.iterator();
        f=true;
    }

    public int next() {
        boolean sent;
        sent=false;
        while (!sent){
            try {
                if(f){
                    f=false;sent=true;
                    return itf.next();
                }else{
                    f=true;sent=true;
                    return its.next();
                }}catch (Exception e){
                sent=false;
            }
        }
        return -1;
    }

    public boolean hasNext() {
        return itf.hasNext()||its.hasNext();
    }
}
class solution2{
    public static void main(String[] args) {

        List<Integer> l1= Arrays.asList(1,2);
        List<Integer> l2=Arrays.asList(3,4,5,6);
        ZigzagIterator zit= new ZigzagIterator(Arrays.asList() ,Arrays.asList(3,4,5,6));
        while (zit.hasNext() )
        System.out.println(zit.next());
    }
}

/*
class ZigzagIteratorv2 {
    List<Iterator> iterators;

     ZigzagIteratorv2(List<Integer> v1, List<Integer> v2) {
        iterators=new LinkedList<>();
        iterators.add(v1.iterator());
        iterators.add(v2.iterator());
    }

    public int next() {

         Iterator iterator=iterators.remove(0);
        int ele=(int)iterator.next();

    }

    public boolean hasNext() {

    }
}
*/

