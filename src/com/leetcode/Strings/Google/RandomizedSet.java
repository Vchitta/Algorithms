package com.leetcode.Strings.Google;

import java.util.*;

/**
 * Created by vidyachitta on 6/17/17.
 */
public class RandomizedSet {
    Map<Integer,Integer> set;
    List<Integer> list;
    Random random;


    /** Initialize your data structure here. */
    public RandomizedSet() {
        set=new HashMap<>();
        list=new ArrayList<>();
        random =new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
            if(set.containsKey(val))
                return false;
            else {
                set.put(val, list.size());
                list.add(val);
                return true;
                //return insrtion;
            }
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(set.containsKey(val))
        {
            int index=set.get(val) ;
            if(index<list.size()-1){
            int last=list.get(list.size()-1);
            list.set(index,last);
            set.put(last,index);
        }
        list.remove(list.size()-1);
        set.remove(val);

        return true;
    }
        else return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(random.nextInt(set.size()));
    }
}


 class RandomizedCollection {
    Map<Integer,List<Integer>> set;
    List<Integer> list;
    Random random;
    /** Initialize your data structure here. */
     RandomizedCollection() {
        set=new HashMap<>();
        list=new ArrayList<>();
        random =new Random();

    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {

        if(set.containsKey(val)){
            set.get(val).add(list.size());
            list.add(val);
            return false;
        }else {
            List<Integer> indicies=new ArrayList<>();indicies.add(list.size());
            set.put(val,indicies );
            list.add(val);
            return true;
            //return insrtion;
        }
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(set.containsKey(val))
        {
            int index=set.get(val).get(0) ;
            if(index<list.size()-1){
                int last=list.get(list.size()-1);
                list.set(index,last);
                set.get(last).remove(set.get(last).size()-1);
                set.get(last).add(index);
            }
            list.remove(list.size()-1);
            set.remove(val);

            return true;
        }
        else return false;

    }

    /** Get a random element from the collection. */
    public int getRandom() {
return 1;
    }
}
class Solutio{
    public static void main(String[] args) {
        RandomizedSet randomSet = new RandomizedSet();

// Inserts 1 to the set. Returns true as 1 was inserted successfully.
//     System.out.println(randomSet.insert(1));
//
//
//// Returns false as 2 does not exist in the set.
//        System.out.println(randomSet.remove(2));
//
//// Inserts 2 to the set, returns true. Set now contains [1,2].
//        System.out.println(randomSet.insert(2));
//
//// getRandom should return either 1 or 2 randomly.
//        System.out.println(randomSet.getRandom());
//
//// Removes 1 from the set, returns true. Set now contains [2].
//        System.out.println(randomSet.remove(1));

// 2 was already in the set, so return false.
        System.out.println(randomSet.insert(2));
        System.out.println(randomSet.insert(3));
        System.out.println(randomSet.insert(4));
        System.out.println(randomSet.insert(5));
        System.out.println(randomSet.remove(5));

        System.out.println(randomSet.insert(5));




// Since 2 is the only number in the set, getRandom always return 2.
        System.out.println(randomSet.getRandom());
    }
}
