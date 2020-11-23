package com.karumanchi.searching;

/**
 * Created by vidyachitta on 6/13/17.
 */



class solution1{
	
int binarySearchtwo(int A[], int l, int r, int key){
		
		int m;
		
		while(l<=r){
			m=l+(r-l)/2;
			if(A[m]== key)
				return m;
			 if(key <A[m])
			 r =m-1;
			else l=m+1;
		}
		return -1;
	}
	
	
int binarySearchOne(int A[], int l, int r, int key){
		
		int m;
		
		while(r-l>1){
			m=l+(r-l)/2;
			if(A[m]<= key)
				l=m;
			else r=m;
		}

		if(A[l]== key)
			return l;
		else if(A[r]== key)
			return r;
		else
		return -1;
	}
	
	
	int getFloor(int A[], int l, int r, int key){
		
		int m;
		
		while(r-l>1){
			m=l+(r-l)/2;
			if(A[m]<= key)
				l=m;
			else r=m;
		}
		
		
		return A[l];
	}
	
	
    // Input: Indices Range [l ... r)
// Invariant: A[l] <= key and A[r] > key
    int GetRightPosition(int A[], int l, int r, int key)
    {
        int m;

        while( r - l > 1 )
        {
            m = l + (r - l)/2;

            if( A[m] <= key )
                l = m;
            else
                r = m;
        }

        return l;
    }
    int GetLeftPositionTwo(int A[], int l, int r, int key)
    {
        int m;

        while( l<= r )
        {
            m = l + (r - l)/2;
            if( A[m] == key &&(m == l || A[m-1] < key) )
            	return m;
            else if( A[m] >= key )
                r = m-1;
            else
                l = m+1;
        }

        return -1;
    }
    public int firstBadVersion(int n) {
        
        int l=1,r=n,m;

            while( l<= r )
            {
                m = l + (r - l)/2;
                if(isBadVersion(m) &&(m == l || !(isBadVersion(m-1))) )
                	return m;
                else if( isBadVersion(m) )
                    r = m-1;
                else
                    l = m+1;
            }
            return -1;
            
        }
    
    private boolean isBadVersion(int m) {
		if(m>=4) return true;
		return false;
	}


	int GetRightPositionTwo(int A[], int l, int r, int key)
    {
        int m;

        while( l<= r )
        {
            m = l + (r - l)/2;
            if( A[m] == key &&(m == r || A[m+1] > key) )
            	return m;
            else if( A[m] > key )
                r = m-1;
            else
                l = m+1;
        }

        return -1;
    }
    // Input: Indices Range (l ... r]
// Invariant: A[r] >= key and A[l] > key
    int GetLeftPosition(int A[], int l, int r, int key)
    {
        int m;

        while( r - l > 1 )
        {
            m = l + (r - l)/2;

            if( A[m] >= key )
                r = m;
            else
                l = m;
        }

        return r;
    }

    int CountOccurances(int A[], int size, int key)
    {
        // Observe boundary conditions
        int left = GetLeftPosition(A, -1, size-1, key);
        int right = GetRightPosition(A, 0, size, key);

        // What if the element doesn't exists in the array?
        // The checks helps to trace that element exists
        return (A[left] == key && key == A[right])?
                (right - left + 1) : 0;
    }
}
public class UbiquitousBinarySearch {

    public static void main(String[] args) {
        solution1 sol = new solution1();
        int[] A= {1,1,1,6 };
        int[] B= {6,6,6,6,8,9,10};
      //  System.out.println(sol.binarySearchtwo(A, 0, A.length,6));
        //System.out.println(sol.binarySearchOne(B, 0, B.length, 2));

        //System.out.println(sol.getFloor(B, 0, B.length, 5));       
      //  System.out.println(sol.GetLeftPositionTwo(A, 0, A.length-1, 1));
    //    System.out.println(sol.GetRightPositionTwo(B, 0, B.length-1,6));
        System.out.println("Bad Version: "+sol.firstBadVersion(5));

       // System.out.println(sol.GetRightPosition(B, 0, B.length, 5));
       // System.out.println(sol.CountOccurances(A,A.length,6));
    }

}
