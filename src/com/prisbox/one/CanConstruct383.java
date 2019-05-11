/**
 * 
 */
package com.prisbox.one;

/**
 * @author admin
 *
 */
public class CanConstruct383 {
	public boolean canConstruct(String ransomNote, String magazine) {
		if (ransomNote.length() > magazine.length()) {
			return false;
		}
		int[] t = new int[26];
		for (int i = 0; i < magazine.length(); i++) {
			int index = magazine.charAt(i) - 'a';
			t[index] = t[index] + 1;
		}
		for (int j = 0; j < ransomNote.length(); j++) {
			int index = ransomNote.charAt(j) - 'a';
			if (t[index] <= 0) {
				return false;
			} else {
				t[index] = t[index] - 1;
			}
		}
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

}
