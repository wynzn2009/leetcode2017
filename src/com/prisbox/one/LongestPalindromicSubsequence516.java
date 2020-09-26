/**
 * 
 */
package com.prisbox.one;

/**
 * @author wynzn 给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度。可以假设 s 的最大长度为 1000 。
 * 
 *          
 * 
 *         示例 1: 输入:
 * 
 *         "bbbab" 输出:
 * 
 *         4 一个可能的最长回文子序列为 "bbbb"。
 * 
 *         示例 2: 输入:
 * 
 *         "cbbd" 输出:
 * 
 *         2 一个可能的最长回文子序列为 "bb"。
 * 
 *          
 * 
 *         提示：
 * 
 *         1 <= s.length <= 1000 s 只包含小写英文字母
 * 
 *         来源：力扣（LeetCode）
 *         链接：https://leetcode-cn.com/problems/longest-palindromic-subsequence
 *         著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestPalindromicSubsequence516 {
	public int longestPalindromeSubseq(String s) {
		int n = s.length();
		char[] chars=s.toCharArray();
		int[][] dp = new int[n][n];
		for (int i = n - 1; i >= 0; i--) {
			dp[i][i] = 1;
			for (int j = i + 1; j < n; j++) {
				if (chars[j] == chars[i]) {
					dp[i][j] = dp[i + 1][j - 1] + 2;
				} else {
					dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[0][n - 1];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
