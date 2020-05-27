/**
 * 
 */
package com.prisbox.one;

/**
 * @author LO 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 
 *         示例 1：
 * 
 *         输入: "babad" 输出: "bab" 注意: "aba" 也是一个有效答案。 示例 2：
 * 
 *         输入: "cbbd" 输出: "bb"
 * 
 *         来源：力扣（LeetCode）
 *         链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 *         著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestPalindromicSubstring5 {
	public String longestPalindrome(String s) {
		if (s.length() < 2) {
			return s;
		}
		int start = 0;
		int len = 1;
		boolean[][] dp = new boolean[s.length()][s.length()];
		for (int j = 1; j < s.length(); j++) {
			for (int i = 0; i < j; i++) {
				if (s.charAt(i) != s.charAt(j)) {
					dp[i][j] = false;
				} else {
					if (j - i >= 3) {
						dp[i][j] = dp[i + 1][j - 1];
					} else {
						dp[i][j] = true;
					}
				}
				if (dp[i][j] && j - i + 1 > len) {
					len = j - i + 1;
					start = i;
				}
			}
		}
		return s.substring(start, start + len);
	}

	public static String longestPalindrome1(String s) {
		if (s.length() < 2) {
			return s;
		}
		char[] ch = s.toCharArray();
		int start = 0;
		int len = 1;
		for (int i = 0; i < s.length()-1; i++) {
			int left = i;
			int right = i;
			while (left >=0 && right < s.length()) {
				if (ch[left] == ch[right]) {
					left--;
					right++;
				} else {
					break;
				}
			}
			if (right - left + 1 - 2 > len) {
				len = right - left + 1 - 2;
				start = left + 1;
			}
			left = i;
			right = i+1;
			if (ch[left] == ch[right]) {
				while (left >=0 && right < s.length()) {
					if (ch[left] == ch[right]) {
						left--;
						right++;
					} else {
						break;
					}
				}
				if (right - left + 1 - 2 > len) {
					len = right - left + 1 - 2;
					start = left + 1;
				}
			}
		}
		return s.substring(start, start + len);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(LongestPalindromicSubstring5.longestPalindrome1("ccc"));
	}

}
