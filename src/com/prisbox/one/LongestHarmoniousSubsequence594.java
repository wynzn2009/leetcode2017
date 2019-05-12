/**
 * 
 */
package com.prisbox.one;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author LO 和谐数组是指一个数组里元素的最大值和最小值之间的差别正好是1。
 * 
 *         现在，给定一个整数数组，你需要在所有可能的子序列中找到最长的和谐子序列的长度。
 * 
 *         示例 1:
 * 
 *         输入: [1,3,2,2,5,2,3,7] 输出: 5 原因: 最长的和谐数组是：[3,2,2,2,3]. 说明:
 *         输入的数组长度最大不超过20,000.
 */
public class LongestHarmoniousSubsequence594 {
	public int findLHS(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int x = nums[i];
			map.put(x, map.get(x) == null ? 1 : map.get(x) + 1);
		}
		Set<Integer> set = map.keySet();
		int max = 0;
		for (Integer key : set) {
			if (!map.containsKey(key + 1)) {
				continue;
			}
			max = Math.max(max, map.get(key) + map.get(key + 1));
		}
		return max;
	}

	public static int findLHS1(int[] nums) {
		if (nums.length < 1) {
			return 0;
		}
		Arrays.sort(nums);
		int max = 0;
		int min = nums[0];
		int count = 1;
		int total = 0;
		for (int i = 1; i < nums.length; i++) {
			int s = nums[i];
			if (s == min) {
				count++;
			} else if (s == min + 1) {
				total++;
			} else if (total != 0) {
				max = Math.max(max, total + count);
				if (s == min + 2) {
					count = total;
					total = 1;
					min = min + 1;
				} else {
					min = s;
					count = 1;
					total = 0;
				}
			}else {
				min = s;
				count = 1;
				total = 0;
			}
		}
		if (total != 0) {
			return Math.max(max, count + total);
		} else {
			return max;
		}
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 3, 1, -14, 13, 4 };
		LongestHarmoniousSubsequence594.findLHS1(nums);
	}
}
