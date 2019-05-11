/**
 * 
 */
package com.prisbox.one;

/**
 * @author admin
 *
 */
public class ReverseStringII {
	public String reverseStr(String s, int k) {
		if (s.length() <= 1 || k <= 1) {
			return s;
		}
		char[] ch = s.toCharArray();
		for (int i = 0; i < (s.length() - 1) / (2 * k) + 1; i++) {
			int t = i * 2 * k;
			int e = t + k - 1;
			if (e >= s.length()) {
				e = s.length() - 1;
			}
			help(ch, t, e);
		}
		return String.valueOf(ch);
	}

	private void help(char[] s, int start, int end) {
		if (start >= end) {
			return;
		}
		while (start < end) {
			s[start] = (char) (s[start] ^ s[end]);
			s[end] = (char) (s[start] ^ s[end]);
			s[start] = (char) (s[start] ^ s[end]);
			start++;
			end--;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ReverseStringII r = new ReverseStringII();
		String s = "abcdefg";
		int k = 2;
		r.reverseStr(s, k);
	}

}
