/**
 * 
 */
package com.prisbox.one;

import java.util.Arrays;

/**
 * @author LO 你的初始能量为 P，初始分数为 0，只有一包令牌。
 * 
 *         令牌的值为 token[i]，每个令牌最多只能使用一次，可能的两种使用方法如下：
 * 
 *         如果你至少有 token[i] 点能量，可以将令牌置为正面朝上，失去 token[i] 点能量，并得到 1 分。
 *         如果我们至少有 1 分，可以将令牌置为反面朝上，获得 token[i] 点能量，并失去 1 分。
 *         在使用任意数量的令牌后，返回我们可以得到的最大分数。
 * 
 *          
 * 
 *         示例 1：
 * 
 *         输入：tokens = [100], P = 50 输出：0 示例 2：
 * 
 *         输入：tokens = [100,200], P = 150 输出：1 示例 3：
 * 
 *         输入：tokens = [100,200,300,400], P = 200 输出：2  
 * 
 *         提示：
 * 
 *         tokens.length <= 1000 0 <= tokens[i] < 10000 0 <= P < 10000
 * 
 *         来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/bag-of-tokens
 *         著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BagofTokens948 {
	public static int bagOfTokensScore(int[] tokens, int P) {
		if (tokens.length == 1 && P >= tokens[0]) {
			return 1;
		}
		Arrays.sort(tokens);
		int l = 0;
		int r = tokens.length - 1;
		int sum = 0;
		while (l <= r) {
			if (P >= tokens[l]) {
				sum++;
				P -= tokens[l++];
			} else if (sum > 0 && r > l) {
				sum--;
				P += tokens[r--];
			} else {
				return sum;
			}
		}
		return sum;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] tokens = { 100, 200 };
		BagofTokens948.bagOfTokensScore(tokens, 150);
	}

}
