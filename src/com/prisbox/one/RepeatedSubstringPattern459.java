/**
 * 
 */
package com.prisbox.one;

/**
 * @author admin
 *
 */
public class RepeatedSubstringPattern459 {
	public static boolean repeatedSubstringPattern(String s) {
		if (s.length() <= 1) {
			return false;
		}
		int t = s.length() % 2 == 1 ? s.length() / 3 : s.length() / 2;
		int index = 1;
		int length = s.length();
		StringBuilder sb = new StringBuilder();
		while (index <= t) {
			if (length % index != 0) {
				index++;
				continue;
			} else {
				sb.append(s.substring(index)).append(s.substring(0, index));
				if (s.equals(sb.toString())) {
					return true;
				} else {
					index++;
					sb.delete(0, sb.length());
				}
			}
		}
		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		repeatedSubstringPattern("abab");
	}

}
