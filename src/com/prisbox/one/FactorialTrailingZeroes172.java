/**
 * 
 */
package com.prisbox.one;

/**
 * @author LO 给定一个整数 n，返回 n! 结果尾数中零的数量。
 * 
 *         示例 1:
 * 
 *         输入: 3 输出: 0 解释: 3! = 6, 尾数中没有零。 示例 2:
 * 
 *         输入: 5 输出: 1 解释: 5! = 120, 尾数中有 1 个零. 说明: 你算法的时间复杂度应为 O(log n) 。
 * 
 *         来源：力扣（LeetCode）
 *         链接：https://leetcode-cn.com/problems/factorial-trailing-zeroes
 *         著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FactorialTrailingZeroes172 {
	public static int trailingZeroes(int n) {
		if (n < 5) {
			return 0;
		}
		int sum = 0;

		while (n > 0) {
			n /= 5;
			sum += n;
		}
		return sum;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FactorialTrailingZeroes172.trailingZeroes(6);
	}

}
