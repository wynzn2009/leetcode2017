/**
 * 
 */
package com.prisbox.one;

import java.util.HashMap;
import java.util.Map;

/**
 * @author admin
 *
 */
public class TwoSum167 {
	public int[] twoSum(int[] numbers, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < numbers.length; i++) {
			int left = target - numbers[i];
			if (map.containsKey(left)) {
				int[] re = new int[2];
				re[0] = map.get(left);
				re[1] = i + 1;
				return re;
			} else {
				map.put(numbers[i], i + 1);
			}
		}
		return null;
	}

	public int[] twoSum1(int[] numbers, int target) {
		int[] re = new int[2];
		int l = 0;
		int r = numbers.length-1;
		while (l < r) {
			if (numbers[l] + numbers[r] == target) {
				re[0] = l + 1;
				re[1] = r + 1;
				return re;
			} else if (numbers[l] + numbers[r] < target) {
				l++;
			} else {
				r--;
			}
		}
		return re;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
