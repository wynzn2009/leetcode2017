/**
 * 
 */
package com.prisbox.one;

/**
 * @author 015422404
 *
 *         如果正整数可以被 A 或 B 整除，那么它是神奇的。
 * 
 *         返回第 N 个神奇数字。由于答案可能非常大，返回它模 10^9 + 7 的结果。
 * 
 * 
 * 
 *         示例 1：
 * 
 *         输入：N = 1, A = 2, B = 3 输出：2 示例 2：
 * 
 *         输入：N = 4, A = 2, B = 3 输出：6 示例 3：
 * 
 *         输入：N-' = 5, A = 2, B = 4 输出：10 示例 4：
 * 
 *         输入：N = 3, A = 6, B = 4 输出：8
 */
public class NthMagicalNumber878 {
	public static int nthMagicalNumber(int N, int A, int B) {
		if (A % B == 0 || B % A == 0) {
			long a = Math.min(A, B);
			return (int) (a * N % 1000000007);
		}
		long m = m(A, B);
		long count = count(A, B, m);
		long n = N / count;
		long start = count * n;
		if (start == N) {
			return (int) (m * n % 1000000007);
		}
		long x = m * n + A;
		long y = m * n + B;
		start++;
		while (start++ < N) {
			if (x < y) {
				x += A;
			} else if (x > y) {
				y += B;
			} else {
				x += A;
				y += B;
			}
		}
		return (int) (Math.min(x, y) % 1000000007);
	}

	private static long m(int a, int b) {
		int max = Math.max(a, b);
		int min = Math.min(a, b);
		while (true) {
			int temp = max % min;
			if (temp == 0) {
				break;
			} else {
				max = Math.max(temp, min);
				min = Math.min(temp, min);
			}
		}
		return (a / min) * b;
	}

	private static long count(int a, int b, long m) {
		return m / a + m / b - 1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(NthMagicalNumber878.nthMagicalNumber(10, 10, 8));
	}

}
