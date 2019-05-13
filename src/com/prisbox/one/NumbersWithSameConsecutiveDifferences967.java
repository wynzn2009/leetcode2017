/**
 * 
 */
package com.prisbox.one;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author LO
 *
 */
public class NumbersWithSameConsecutiveDifferences967 {
	public static int[] numsSameConsecDiff(int N, int K) {
		if (N == 1) {
			return new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		}
		LinkedList<Integer> l = new LinkedList<Integer>();
		int i = 1;
		l.push(i);
		ArrayList<Integer> re = new ArrayList<>();
		StringBuffer sb = new StringBuffer();
		while (i < 10) {
			st(l, N, K, re, sb);
			i++;
			l.push(i);
		}
		int[] result = new int[re.size()];
		for (int j = 0; j < re.size(); j++) {
			result[j] = re.get(j);
		}
		return result;
	}

	private static void st(LinkedList<Integer> l, int N, int K, ArrayList<Integer> re, StringBuffer sb) {
		if (l.size() == N) {
			re.add(help(l, N, sb));
			int last = l.pop();
			/*
			 * int last = l.pop(); int peek = l.peek(); if (peek > last && peek + K < 10) {
			 * l.push(peek + K); st(l, N, K, re, sb); }
			 */
			return;
		} else if (l.size() == 0) {
			return;
		} else {
			int peek = l.peek();
			if (peek - K >= 0) {
				l.push(peek - K);
				st(l, N, K, re, sb);
			}
			if (peek + K < 10 && K != 0) {
				l.push(peek + K);
				st(l, N, K, re, sb);
			}
			l.pop();
			return;
		}

	}

	private static int help(LinkedList<Integer> l, int N, StringBuffer sb) {
		for (int i = N - 1; i >= 0; i--) {
			sb.append(l.get(i));
		}
		int re = Integer.valueOf(sb.toString());
		sb.setLength(0);
		return re;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumbersWithSameConsecutiveDifferences967.numsSameConsecDiff(1, 0);
	}

}
