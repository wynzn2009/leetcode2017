/**
 * 
 */
package com.prisbox.one;

import java.util.Arrays;

/**
 * @author 015422404 在大小为 2N 的数组 A 中有 N+1 个不同的元素，其中有一个元素重复了 N 次。
 * 
 *         返回重复了 N 次的那个元素。
 * 
 *          
 * 
 *         示例 1：
 * 
 *         输入：[1,2,3,3] 输出：3 示例 2：
 * 
 *         输入：[2,1,2,5,3,2] 输出：2 示例 3：
 * 
 *         输入：[5,1,5,2,5,3,5,4] 输出：5  
 * 
 *         提示：
 * 
 *         4 <= A.length <= 10000 0 <= A[i] < 10000 A.length 为偶数
 * 
 */
public class NRepeatedElementinSize2NArray961 {
	public static int repeatedNTimes(int[] A) {
		Arrays.sort(A);
		int left = A.length - 1;
		int count = 1;
		int ind = 1;
		int tmp = A[0];
		while (count < left) {
			if (A[ind] == tmp) {
				count++;
			} else if (--count < 0) {
				count = 1;
				tmp = A[ind];
			}
			left--;
			ind++;
		}
		return tmp;
	}

	public static int repeatedNTimes1(int[] A) {

		for (int i = 2; i < A.length; i++) {
			if (A[i - 2] == A[i - 1]) {
				return A[i - 1];
			}
			if (A[i - 2] == A[i]) {
				return A[i];
			}
			if (A[i - 1] == A[i]) {
				return A[i];
			}
		}
		return A[0];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = { 2, 1, 2, 5, 3, 2 };
		System.out.print(NRepeatedElementinSize2NArray961.repeatedNTimes(A));
	}

}
