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
public class SuperPow372Sec {
	public int superPow(int a, int[] b) {
		a %= 1337;
		int b0 = b[0];
		for (int i = 1; i < b.length; i++) {
			b0 = b0 * 10 + b[i];
			b0 %= 1140;
		}
		if (a % 7 == 0 || a % 191 == 0) {
			b0 += 1140;
		}
		int ans = 1;
		while (b0 > 0) {
			if ((b0 & 1) == 1) {
				ans = (ans * a) % 1337;
			}
			a = (a * a) % 1337;
			b0 >>= 1;
		}
		return ans;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SuperPow372Sec s = new SuperPow372Sec();
		int[] n = { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		int re = s.superPow(2, n);
		System.out.println(re);
	}

}
