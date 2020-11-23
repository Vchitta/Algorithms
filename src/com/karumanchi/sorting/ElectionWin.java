package com.karumanchi.sorting;

import java.util.Arrays;

public class ElectionWin {

	
	public int checkWhoWinsElection(int[] votes){
		
		if(votes.length ==0) return -1;
		if(votes.length ==1) return votes[0];
		Arrays.sort(votes); // can do a counting sort 
		int candidate= votes[0] , maxCandidate =votes[0] , maxCount =1, count =1;
		for(int i =1;i<votes.length;i++){
			if(candidate == votes[i])
			{
				count ++;
			}else{
				candidate = votes[i];
				count =1;
			}
			
			
			if(count >maxCount){
				maxCandidate = candidate;
				maxCount = count;
			}
			
			
		}
		
		
		return maxCandidate;
		
	}
	
	public static void main(String[] args) {
		System.out.println("Max number of votes are for candidate: "+new ElectionWin().checkWhoWinsElection(new int[]{1,1,1,1,1,1,12,2,2,3,3,3,3,3,3,3,3,3,3,3,3}));
	}
}
