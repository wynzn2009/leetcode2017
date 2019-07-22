/**
 * 
 */
package com.prisbox.one;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author admin
 *
 */
public class FrequencySort451 {
	public static String frequencySort(String s) {
		TreeSet<Param> map = new TreeSet<Param>(new Comparator<Param>() {

			@Override
			public int compare(Param o1, Param o2) {
				// TODO Auto-generated method stub
				if (o2.getCount() == o1.getCount()) {
					return o2.getName() - o1.getName();
				} else {
					return o2.getCount() - o1.getCount();
				}
			}
		});

		int[] a = new int[256];
		Arrays.fill(a, 0);

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			a[c] = a[c] + 1;
		}
		for (int i = 0; i < 256; i++) {
			if (a[i] > 0) {
				map.add(new Param(a[i], i));
			}
		}
		StringBuffer ab = new StringBuffer();
		for (Param p : map) {
			char[] ss = new char[p.count];
			Arrays.fill(ss, p.getName());
			ab.append(ss);
		}
		return ab.toString();
	}

	static class Param {
		private int count;
		private char name;

		public Param(int count, int index) {
			this.count = count;
			this.name = (char) (index);
		}

		public int getCount() {
			return count;
		}

		public void setCount(int count) {
			this.count = count;
		}

		public char getName() {
			return name;
		}

		public void setName(char name) {
			this.name = name;
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(FrequencySort451.frequencySort("Aabb"));
	}

}
