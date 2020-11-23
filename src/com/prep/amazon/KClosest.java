package com.prep.amazon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;


class Kpoint{
	Double dist;
	@Override
	public String toString() {
		return "Kpoint [dist=" + dist + ", point=" + Arrays.toString(point) + "]";
	}
	int[] point;
	public Kpoint(Double dist, int[] point) {
		super();
		this.dist = dist;
		this.point = point;
	}

}

class PointComp  implements Comparator<int[]>{

	@Override
	public int compare(int[] o1, int[] o2) {
		
		return new Integer(o1[0]*o1[0]+o1[1]*o1[1]).compareTo(new Integer(o2[0]*o2[0]+o2[1]*o2[1]));
	}

	
	
	
}
public class KClosest {
	
	
    public int[][] kClosest(int[][] points, int K) {
    	
    	int[][] res= new int[K][2];
        PriorityQueue<int[]> pQueue = new PriorityQueue<int[]>(new PointComp()); 
        for(int[] point: points){
       // 	Double dOrigin = Math.pow(point[0], 2)+Math.pow(point[1], 2);
        //	Kpoint kpoint = new Kpoint(dOrigin,point);
        	pQueue.offer(point);
        	//if(pQueue.size()>K)pQueue.poll();
        }
        
        System.out.println(pQueue);
        for(int i=0;i<K;i++)
        {
        	res[i]=pQueue.poll();
        	}
        	
        return res;
   
}
    
    public static void main(String[] args) {
    	int[][] points ={{1,3},{-2,2}};
    			
    	System.out.println(Arrays.deepToString(new KClosest().kClosest(points, 1)));
    	
	}

}

