package com.Interviews.Google;

public class bundle {


	static int budgetShopping(int n, int[] bundleQuantities, int[] bundleCosts) {
		 if (n == 0 || bundleQuantities.length == 0)
		        return 0;
		int[] arrayK = new int[n+1];
		int numBundles = bundleCosts.length;
		for (int i=0; i<=n; i++)
			for (int j=0; j<numBundles; j++)
				if (bundleCosts[j] <= i)
					arrayK[i] = Math.max(arrayK[i], arrayK[i-bundleCosts[j]]+bundleQuantities[j]);

		return arrayK[n];
	}
	public static void main(String[] args){


		int[] bundleQuantities = {10};
		int[] bundleCosts= {2};
		System.out.println( budgetShopping(4, bundleQuantities, bundleCosts));
	}


}
