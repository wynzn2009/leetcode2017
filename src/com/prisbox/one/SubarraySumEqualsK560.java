/**
 * 
 */
package com.prisbox.one;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LO 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 * 
 *         示例 1 :
 * 
 *         输入:nums = [1,1,1], k = 2 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。 说明 :
 * 
 *         数组的长度为 [1, 20,000]。 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 * 
 *         来源：力扣（LeetCode）
 *         链接：https://leetcode-cn.com/problems/subarray-sum-equals-k
 *         著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SubarraySumEqualsK560 {
	public static int subarraySum(int[] nums, int k) {
		int[] sum = new int[nums.length + 1];
		sum[0] = 0;
		for (int i = 0; i < nums.length; i++) {
			sum[i + 1] = sum[i] + nums[i];
		}
		int re = 0;
		for (int j = 0; j < nums.length; j++) {
			int l = nums.length;
			while (l > j) {
				if (sum[l--] - sum[j] == k) {
					re++;
				}
			}
		}
		return re;
	}

	public static int subarraySum1(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, 1);
		int re = 0;
		int sum = 0;
		for (int num : nums) {
			sum += num;
			if (map.containsKey(sum - k)) {
				re += map.get(sum - k);
			}
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
		return re;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k = 2;
		int[] nums = { 1, 1, 1 };
		SubarraySumEqualsK560.subarraySum(nums, k);
	}

}
