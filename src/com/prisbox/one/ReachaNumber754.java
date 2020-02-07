/**
 * 
 */
package com.prisbox.one;

/**
 * @author LO 在一根无限长的数轴上，你站在0的位置。终点在target的位置。
 * 
 *         每次你可以选择向左或向右移动。第 n 次移动（从 1 开始），可以走 n 步。
 * 
 *         返回到达终点需要的最小移动次数。
 * 
 *         示例 1:
 * 
 *         输入: target = 3 输出: 2 解释: 第一次移动，从 0 到 1 。 第二次移动，从 1 到 3 。 示例 2:
 * 
 *         输入: target = 2 输出: 3 解释: 第一次移动，从 0 到 1 。 第二次移动，从 1 到 -1 。 第三次移动，从 -1
 *         到 2 。 注意:
 * 
 *         target是在[-10^9, 10^9]范围中的非零整数。
 * 
 *         来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/reach-a-number
 *         著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReachaNumber754 {
	public static int reachNumber(int target) {
		boolean du = (target & 1) == 0;
		int ind = (int) Math.sqrt(Math.abs(target + target)) + 1;
		int sum = ind * (ind - 1) / 2;
		if (sum >= Math.abs(target)) {
			ind = ind - 1;
		}
		if (du) {
			if (ind % 4 == 0 || (ind + 1) % 4 == 0) {
				return ind;
			} else {
				return (ind / 4 + 1) * 4 - 1;
			}
		} else {
			if ((ind - 1) % 4 == 0 || (ind - 2) % 4 == 0) {
				return ind;
			} else {
				return ((ind - 1) / 4 + 1) * 4 + 1;
			}
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(ReachaNumber754.reachNumber(-12));
	}

}
