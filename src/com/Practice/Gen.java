package com.Practice;

import java.util.Arrays;

/**
 * Created by vidyachitta on 5/24/17.
 */



public class Gen<T> {
    T ob;
    int no;
    Gen(T o){
        ob = o;
    }
    T getOb(){
        return ob;
    }

    @Override
    public String toString() {
        //return super.toString();
        return "object.ob: "+ob+"\nobject.no: "+no;
    }

    public static void main(String[] args) {
        Gen<Integer> iob= new Gen<Integer>(5);
        int ret = iob.getOb();
        iob.no = 99;
        Gen<String> sob = new Gen<String>("hi");
        String re = sob.getOb();
//        System.out.println(iob.toString());
//        System.out.println(sob.toString());
//        System.out.println("ret is: "+ret+"\nre is: "+re);
    }
}

class nongen{
    Object ob;
    nongen(Object o){
        ob = o;
    }
    Object getOb(){
        return ob;
    }

    public static void main(String[] args) {
        nongen ing = new nongen(5);
        nongen sng = new nongen("hi");
        System.out.println(ing.getOb()+"  "+sng.getOb());

        int ri = (Integer) ing.getOb();
        String rs = (String) sng.getOb();
       // System.out.println("ri is: "+ri);

        ing = sng;
        //ri = (Integer) ing.getOb();
       // System.out.println("ri is: "+ri);
    }
}
class Ave<T extends Number>{
    T[] arr;


    Ave(T[] arr) {
        this.arr = arr;
    }

    T[] getArr(){
        return arr;
    }

    double dave(){
        double average = 0;
        for (T x: arr){
            average += x.doubleValue();
        }
        average = average/arr.length;
        System.out.println("average of "+ Arrays.toString(getArr())+" is: "+average);
        return average;
    }
    boolean sameave(Ave<?> ob){
        if(this.dave() == ob.dave())
            return true;
        return false;
    }

    public static void main(String[] args) {
        Integer[] A = {1,2,3,4,5,6,7,8,9};
        Ave<Integer> iave = new Ave<Integer>(A);
        Double[] D ={1.2,34.5,55.6,654.3};
        Ave<Double> cave = new Ave<Double>(D);
        double i = iave.dave();
        double d = cave.dave();
        System.out.println(iave.sameave(cave));
    }
}

class Genmeth{
    double ave;
    Genmeth(double d){

    }
    <T,V extends T> boolean issame(T ele,V[] arr){
        for (V x:arr){
            if (ele == x)
                return true;
        }
        return false;
    }
}