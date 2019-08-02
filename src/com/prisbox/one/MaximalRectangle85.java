/**
 * 
 */
package com.prisbox.one;

/**
 * @author 015422404 给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 * 
 *         示例:
 * 
 *         输入: [ ["1","0","1","0","0"], ["1","0","1","1","1"],
 *         ["1","1","1","1","1"], ["1","0","0","1","0"] ] 输出: 6
 * 
 */
public class MaximalRectangle85 {
	public static int maximalRectangle(char[][] matrix) {
		if (matrix.length < 1) {
			return 0;
		}
		int m = matrix.length;
		int n = matrix[0].length;

		Param[][] dp = new Param[m + 1][n + 1];
		for (int i = 0; i < m + 1; i++) {
			dp[i][0] = new Param();
		}
		for (int i = 0; i < n + 1; i++) {
			dp[0][i] = new Param();
		}
		int max = 0;
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (matrix[i - 1][j - 1] == '1') {
					Param up = dp[i - 1][j];
					Param left = dp[i][j - 1];
					Param mid = dp[i - 1][j - 1];
					int up1 = 0;
					int le1 = 0;
					int upsum = 0;
					int lesum = 0;
					int midsum = 0;
					if (up.sum != 0 && left.sum == 0) {
						dp[i][j] = new Param(up.len + 1, 1, up.len + 1, up.len + 1, 1);
					} else if (up.sum == 0 && left.sum != 0) {
						dp[i][j] = new Param(1, left.wid + 1, left.wid + 1, 1, left.wid + 1);
					} else if (up.sum == 0 && left.sum == 0) {
						dp[i][j] = new Param(1, 1, 1, 1, 1);
					} else {
						up1 = up.len + 1;
						le1 = left.wid + 1;
						upsum = (up.lena + 1) * Math.min(le1, up.widb);
						lesum = (left.widb + 1) * Math.min(up1, left.lena);
						midsum = (Math.min(mid.lena, up.len) + 1) * (Math.min(mid.widb, left.wid) + 1);

						if (midsum >= up1 && midsum >= le1 && midsum >= upsum && midsum >= lesum) {
							dp[i][j] = new Param(up1, le1, midsum, Math.min(mid.lena, up.len) + 1,
									Math.min(mid.widb, left.wid) + 1);
						} else if (upsum >= up1 && upsum >= le1 && upsum >= lesum && upsum >= midsum) {
							dp[i][j] = new Param(up1, le1, upsum, up.lena + 1, Math.min(le1, up.widb));
						} else if (lesum >= up1 && lesum >= le1 && lesum >= upsum && lesum >= midsum) {
							dp[i][j] = new Param(up1, le1, lesum, Math.min(up1, left.lena), left.widb + 1);
						} else if (up1 >= le1 && up1 >= upsum && up1 >= lesum && up1 >= midsum) {
							dp[i][j] = new Param(up1, le1, up1, up1, 1);
						} else {
							dp[i][j] = new Param(up1, le1, le1, 1, le1);
						}
					}
					max = Math.max(max, dp[i][j].sum);
				} else {
					dp[i][j] = new Param();
				}
			}
		}
		return max;
	}

	static class Param {
		public int len;
		public int wid;
		public int sum;
		public int lena;
		public int widb;

		public Param() {
			super();
			this.len = 0;
			this.wid = 0;
			this.sum = 0;
			this.lena = 0;
			this.widb = 0;
		}

		public Param(int len, int wid, int sum, int lena, int widb) {
			super();
			this.len = len;
			this.wid = wid;
			this.sum = sum;
			this.lena = lena;
			this.widb = widb;
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		char[][] matrix = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
				{ '1', '0', '0', '1', '0' } };
		// TODO Auto-generated method stub
		System.out.print(MaximalRectangle85.maximalRectangle(matrix));
	}

}
