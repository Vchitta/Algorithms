package com.Interviews.Google;

/**
 * Created by vidyachitta on 6/18/17.
 */
public class Second {
    public int[] solution(int[] A, int k){

        if(A == null || A.length < k)
            return null;
        if(A.length == k)
            return A;
        int max = 0;
        for(int i=0; i<=A.length-k; i++)
            if(A[max]<A[i]) max = i;

        int[] output = new int[k];
        for(int i=0; i<k; i++)
            output[i] = A[max+i];

        return output;
    }
}
