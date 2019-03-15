/**
 * 
 */
package com.prisbox.one;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @author LO
 *
 *         你的任务是计算 ab 对 1337 取模，a 是一个正整数，b 是一个非常大的正整数且会以数组形式给出。
 * 
 *         示例 1:
 * 
 *         输入: a = 2, b = [3] 输出: 8 示例 2:
 * 
 *         输入: a = 2, b = [1,0] 输出: 1024
 */
public class SuperPow372 {
	public int superPow(int a, int[] b) {
		if(a==0) {
			return 0;
		}
		if(a==1) {
			return 1;
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			sb.append(b[i]);
		}
		BigInteger total = new BigInteger(sb.toString());
		// int left = Integer.MAX_VALUE;
		List<Integer> list = new ArrayList<>();

		while (total.compareTo(BigInteger.ZERO) > 0) {
			int t = help(a);
			int m = mod(a, t);
			BigInteger z = total.divide(BigInteger.valueOf(t));
			int left = total.mod(BigInteger.valueOf(t)).intValue();
			total = z;
			list.add((int) Math.pow(a, left));
			a = m;
		}
		int re = 1;
		for (int j = 0; j < list.size(); j++) {
			re = (re * list.get(j)) % 1337;
		}
		return re;
	}

	private int help(int a) {
		return (int) (Math.log(1337) / Math.log(a)) + 1;
	}

	private int mod(int a, int n) {
		int sum = (int) Math.pow(a, n);
		return sum % 1337;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SuperPow372 s = new SuperPow372();
		int[] n = { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		int re = s.superPow(2, n);
		System.out.println(re);
	}

}
