/**
 * 
 */
package com.prisbox.one;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LO
 *
 */
public class Level {
	public static List<Integer> mai(String t) {
		String[] a = t.split(",");
		List<Integer> re = new ArrayList<Integer>();
		List<Integer> arr = new ArrayList<Integer>();
		int ind = 0;
		int la = 1;
		arr.add(Integer.valueOf(a[0]));
		while (la < a.length) {
			if (arr.get(ind) != null) {
				arr.add("#".equals(a[la]) ? null : Integer.valueOf(a[la]));
				la++;
				if (la < a.length) {
					arr.add("#".equals(a[la]) ? null : Integer.valueOf(a[la]));
					la++;
				}
			}else {
				arr.add(null);
				arr.add(null);
			}
			ind++;
		}
		help(0, re, arr);
		return re;
	}

	public static void help(int index, List<Integer> re, List<Integer> arr) {
		if (arr.get(index) == null) {
			return;
		} else {
			re.add(arr.get(index));
		}
		int left = index * 2 + 1;
		int right = index * 2 + 2;
		if (left < arr.size()) {
			help(left, re, arr);
		}
		if (right < arr.size()) {
			help(right, re, arr);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> re = Level.mai("1,#,2,3,4,#,5,6,7,8,#,9,#,10,#");
		System.out.print(re);
	}

}
