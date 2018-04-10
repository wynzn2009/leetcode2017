/**
 * 
 */

package com.prisbox.one;

/**
 * @author LO
 *
 */
public class NthUglyNumber264 {

	public static int nthUglyNumber(int n) {
		int[] list = new int[n < 5 ? 5 : n];
		list[0] = 1;
		list[1] = 2;
		list[2] = 3;
		list[3] = 4;
		list[4] = 5;
		int a2 = 2;
		int a3 = 1;
		int a5 = 1;
		if (n <= 5) {
			return list[n - 1];
		}
		int index = 5;
		int a22 = list[a2];
		int a33 = list[a3];
		int a55 = list[a5];
		int next = 0;
		while (index < n) {
			next = Math.min(a22 * 2, Math.min(a33 * 3, a55 * 5));
			list[index] = next;
			if (next >= a22 * 2) {
				a2++;
				a22 = list[a2];
			}
			if (next >= a33 * 3) {
				a3++;
				a33 = list[a3];
			}
			if (next >= a55 * 5) {
				a5++;
				a55 = list[a5];
			}
			index++;
		}
		return list[n - 1];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		nthUglyNumber(6);
	}

}
