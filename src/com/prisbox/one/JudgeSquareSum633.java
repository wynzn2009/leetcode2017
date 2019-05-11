/**
 * 
 */
package com.prisbox.one;

/**
 * @author admin
 *
 */
public class JudgeSquareSum633 {
	private int[][][] tails = {
			{ { 1, 3 }, { 1, 7 }, { 2, 4 }, { 2, 6 }, { 5, 5 }, { 3, 9 }, { 7, 9 }, { 4, 8 }, { 6, 8 }, { 0, 0 } },
			{ { 0, 1 }, { 0, 9 }, { 4, 5 }, { 5, 6 } }, { { 1, 1 }, { 1, 9 }, { 9, 9 }, { 4, 4 }, { 4, 6 }, { 6, 6 } },
			{ { 2, 3 }, { 2, 7 }, { 7, 8 }, { 3, 8 } }, { { 0, 2 }, { 0, 8 }, { 3, 5 }, { 5, 7 } },
			{ { 1, 2 }, { 1, 8 }, { 2, 9 }, { 4, 9 }, { 3, 4 }, { 3, 6 }, { 4, 7 }, { 6, 7 }, { 0, 5 } },
			{ { 1, 5 }, { 5, 9 }, { 0, 4 }, { 0, 6 } }, { { 1, 4 }, { 1, 6 }, { 4, 9 }, { 6, 9 } },
			{ { 2, 2 }, { 2, 8 }, { 8, 8 } }, { { 2, 5 }, { 5, 8 }, { 0, 3 }, { 0, 7 } } };

	// public boolean judgeSquareSum(int c) {
	// int tail = c % 10;
	// int sq = (int) (Math.sqrt(c)) + 1;
	// }
	public static boolean judgeSquareSum(int c) {
		// int tail = c % 10;
		int left = (int) (Math.sqrt(c / 2));
		int right = left;
		int sum = 0;
		while (left >= 0) {
			sum = left * left + right * right;
			if (sum > c || sum < 0) {
				left--;
			} else if (sum < c) {
				right++;
			} else {
				return true;
			}
		}
		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		judgeSquareSum(2147482647);
	}
}
