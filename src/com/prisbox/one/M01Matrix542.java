/**
 * 
 */
package com.prisbox.one;

/**
 * @author wynzn 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
 * 
 *         两个相邻元素间的距离为 1 。
 * 
 *         示例 1: 输入:
 * 
 *         0 0 0 0 1 0 0 0 0 输出:
 * 
 *         0 0 0 0 1 0 0 0 0 示例 2: 输入:
 * 
 *         0 0 0 0 1 0 1 1 1 输出:
 * 
 *         0 0 0 0 1 0 1 2 1 注意:
 * 
 *         给定矩阵的元素个数不超过 10000。 给定矩阵中至少有一个元素是 0。 矩阵中的元素只在四个方向上相邻: 上、下、左、右。
 * 
 *         来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/01-matrix
 *         著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M01Matrix542 {
	public int[][] updateMatrix(int[][] matrix) {
		int[][] re = new int[matrix.length][matrix[0].length];
		int maxLeng = matrix.length + matrix[0].length;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 0) {
					re[i][j] = 0;
				} else {
					re[i][j] = maxLeng;
				}
			}
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 0) {
					continue;
				}
				if (i > 0) {
					re[i][j] = Math.min(re[i][j], re[i - 1][j] + 1);
				}
				if (j > 0) {
					re[i][j] = Math.min(re[i][j], re[i][j - 1] + 1);
				}
			}
		}

		for (int i = matrix.length - 1; i >= 0; i--) {
			for (int j = matrix[i].length - 1; j >= 0; j--) {
				if (matrix[i][j] == 0) {
					continue;
				}
				if (i < matrix.length - 1) {
					re[i][j] = Math.min(re[i][j], re[i + 1][j] + 1);
				}
				if (j < matrix[i].length - 1) {
					re[i][j] = Math.min(re[i][j], re[i][j + 1] + 1);
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
