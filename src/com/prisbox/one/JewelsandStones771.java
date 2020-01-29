/**
 * 
 */
package com.prisbox.one;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author LO
 *
 */
public class JewelsandStones771 {

	public static int numJewelsInStones(String J, String S) {
		Matcher re = Pattern.compile("[" + J + "]").matcher(S);
		int count = 0;
		while (re.find()) {
			count++;
		}
		return count;
	}

	public static int numJewelsInStones1(String J, String S) {
		int res = 0;
		char[] re = S.toCharArray();
		char[] re1 = J.toCharArray();
		boolean[] ch = new boolean[128];
		for (char s : re1) {
			ch[s - 'A'] = true;
		}
		for (char s : re) {
			if (ch[s - 'A']) {
				res++;
			}

		}
		return res;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String J = "aA";
		String S = "aAAbbbb";
		JewelsandStones771.numJewelsInStones(J, S);
	}

}
