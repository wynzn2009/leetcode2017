/**
 * 
 */
package com.prisbox.one;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wynzn
 *
 */
public class PancakeSorting969 {
	public List<Integer> pancakeSort(int[] arr) {
		List<Integer> re = new ArrayList<Integer>();

		int n = arr.length;
		while (n >= 0) {
			int ind = findMax(arr, n);
			if (ind + 1 == n) {
				n--;
			} else {
				re.add(ind + 1);
				re.add(n);
				reverse(arr, ind + 1);
				reverse(arr, n);
			}
		}
		return re;
	}

	private int findMax(int[] arr, int tar) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == tar) {
				return i;
			}
		}
		return -1;
	}

	private void reverse(int[] arr, int ct) {
		int start = 0;
		int end = ct - 1;
		while (start < end) {
			arr[start] = arr[start] ^ arr[end];
			arr[end] = arr[start] ^ arr[end];
			arr[start] = arr[start] ^ arr[end];
			start++;
			end--;
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
