/**
 * 
 */
package com.prisbox.one;

/**
 * @author LO 给你一个 m * n 的矩阵 grid，矩阵中的元素无论是按行还是按列，都以非递增顺序排列。 
 * 
 *         请你统计并返回 grid 中 负数 的数目。
 * 
 *          
 * 
 *         示例 1：
 * 
 *         输入：grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]] 输出：8
 *         解释：矩阵中共有 8 个负数。 示例 2：
 * 
 *         输入：grid = [[3,2],[1,0]] 输出：0 示例 3：
 * 
 *         输入：grid = [[1,-1],[-1,-1]] 输出：3 示例 4：
 * 
 *         输入：grid = [[-1]] 输出：1  
 * 
 *         提示：
 * 
 *         m == grid.length n == grid[i].length 1 <= m, n <= 100 -100 <=
 *         grid[i][j] <= 100
 * 
 *         来源：力扣（LeetCode）
 *         链接：https://leetcode-cn.com/problems/count-negative-numbers-in-a-sorted-matrix
 *         著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CountNegativeNumbersinaSortedMatrix1351 {
	public static int countNegatives(int[][] grid) {
		int sum = 0;
		if (grid.length <= 0) {
			return 0;
		}
		int left = 0;
		int botom = grid.length - 1;
		while (left < grid[0].length && botom >= 0) {
			if (grid[botom][left] < 0) {
				sum += grid[0].length - left;
				botom--;
			} else {
				left++;
			}
		}
		return sum;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] grid = { { 5, 1, 0 }, { -5, -5, -5 } };
		// TODO Auto-generated method stub
		CountNegativeNumbersinaSortedMatrix1351.countNegatives(grid);
	}

}
