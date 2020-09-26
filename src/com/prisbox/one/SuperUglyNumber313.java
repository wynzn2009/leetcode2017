/**
 * 
 */
package com.prisbox.one;

import java.util.Arrays;

/**
 * @author wynzn
 *
 */
public class SuperUglyNumber313 {
	public static int nthSuperUglyNumber(int n, int[] primes) {
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return primes[0];
		}
		int index[] = new int[primes.length];
		Arrays.fill(index, 0);

		int dp[] = new int[n];
		dp[0] = 1;
		int k = primes.length;
		for (int i = 1; i < n; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < k; j++) {
				if (min > primes[j] * dp[index[j]]) {
					min = primes[j] * dp[index[j]];
				}
			}

			for (int j = 0; j < k; j++) {
				if (min == primes[j] * dp[index[j]]) {
					index[j]++;
				}
			}

			dp[i] = min;
		}

		return dp[n - 1];

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] primes = { 2, 7, 13, 19 };
		// TODO Auto-generated method stub
		SuperUglyNumber313.nthSuperUglyNumber(12, primes);
	}

}
