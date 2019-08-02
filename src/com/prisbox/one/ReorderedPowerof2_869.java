/**
 * 
 */
package com.prisbox.one;

import java.util.Arrays;

/**
 * @author 015422404 给定正整数 N ，我们按任何顺序（包括原始顺序）将数字重新排序，注意其前导数字不能为零。
 * 
 *         如果我们可以通过上述方式得到 2 的幂，返回 true；否则，返回 false。
 * 
 *          
 * 
 *         示例 1：
 * 
 *         输入：1 输出：true 示例 2：
 * 
 *         输入：10 输出：false 示例 3：
 * 
 *         输入：16 输出：true 示例 4：
 * 
 *         输入：24 输出：false 示例 5：
 * 
 *         输入：46 输出：true  
 * 
 *         提示：
 * 
 *         1 <= N <= 10^9
 * 
 */
public class ReorderedPowerof2_869 {
	public static boolean reorderedPowerOf2(int N) {
		String[][] tab = { { "1", "2", "4", "8" }, { "16", "23", "46" }, { "128", "256", "125" },
				{ "0124", "0248", "0469", "1289" }, { "13468", "23678", "35566" }, { "011237", "122446", "224588" },
				{ "0145678", "0122579", "0134449", "0368888" }, { "11266777", "23334455", "01466788" }, { "112234778", "234455668", "012356789" } };
		if (N == 1000000000) {
			return false;
		}
		char[] t = String.valueOf(N).toCharArray();
		Arrays.sort(t);
		String re = String.valueOf(t);
		int ind = re.length() - 1;
		for (int i = 0; i < tab[ind].length; i++) {
			if (tab[ind][i].equals(re)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReorderedPowerof2_869.reorderedPowerOf2(1);
	}

}
