/**
 * 
 */
package com.prisbox.one;

import java.util.Arrays;

/**
 * @author LO 给定两个数组，编写一个函数来计算它们的交集。
 * 
 *         示例 1:
 * 
 *         输入: nums1 = [1,2,2,1], nums2 = [2,2] 输出: [2] 示例 2:
 * 
 *         输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4] 输出: [9,4]
 * 
 *         来源：力扣（LeetCode）
 *         链接：https://leetcode-cn.com/problems/intersection-of-two-arrays
 *         著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IntersectionofTwoArrays349 {
	public int[] intersection(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int i = 0;
		int j = 0;
		int[] re = new int[Math.min(nums1.length, nums2.length)];
		int ind = 0;
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] == nums2[j] && (ind == 0 || nums1[i] != re[ind - 1])) {
				re[ind++] = nums1[i];
			} else if (nums1[i] > nums2[j]) {
				j++;
				continue;
			} else if (nums1[i] < nums2[j]) {
				i++;
				continue;
			}
			i++;
			j++;
		}
		return Arrays.copyOf(re, ind);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
