/**
 * 
 */
package com.prisbox.one;

import java.util.Arrays;

/**
 * @author wynzn 一个整数区间 [a, b]  ( a < b ) 代表着从 a 到 b 的所有连续整数，包括 a 和 b。
 * 
 *         给你一组整数区间intervals，请找到一个最小的集合 S，使得 S
 *         里的元素与区间intervals中的每一个整数区间都至少有2个元素相交。
 * 
 *         输出这个最小集合S的大小。
 * 
 *         示例 1:
 * 
 *         输入: intervals = [[1, 3], [1, 4], [2, 5], [3, 5]] 输出: 3 解释: 考虑集合 S =
 *         {2, 3, 4}. S与intervals中的四个区间都有至少2个相交的元素。 且这是S最小的情况，故我们输出3。 示例 2:
 * 
 *         输入: intervals = [[1, 2], [2, 3], [2, 4], [4, 5]] 输出: 5 解释: 最小的集合S =
 *         {1, 2, 3, 4, 5}. 注意:
 * 
 *         intervals 的长度范围为[1, 3000]。 intervals[i] 长度为 2，分别代表左、右边界。
 *         intervals[i][j] 的值是 [0, 10^8]范围内的整数。
 * 
 *         来源：力扣（LeetCode）
 *         链接：https://leetcode-cn.com/problems/set-intersection-size-at-least-two
 *         著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SetIntersectionSizeAtLeastTwo757 {
	public int intersectionSizeTwo(int[][] intervals) {
		Arrays.sort(intervals, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);

		int[] forTwo = new int[intervals.length];
		Arrays.fill(forTwo, 2);
		int n = intervals.length;
		int re = 0;
		while (n-- > 0) {
			int t = forTwo[n];
			if (t <= 0) {
				continue;
			}
			re += t;
			for (int i = intervals[n][0]; i < intervals[n][0] + t; i++) {
				for (int j = n; j >= 0; j--) {
					if (i <= intervals[j][1]) {
						forTwo[j]--;
					}
				}
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
