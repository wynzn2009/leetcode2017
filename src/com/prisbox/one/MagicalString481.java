/**
 * 
 */
package com.prisbox.one;

/**
 * @author LO 神奇的字符串 S 只包含 '1' 和 '2'，并遵守以下规则：
 * 
 *         字符串 S 是神奇的，因为串联字符 '1' 和 '2' 的连续出现次数会生成字符串 S 本身。
 * 
 *         字符串 S 的前几个元素如下：S = “1221121221221121122 ......”
 * 
 *         如果我们将 S 中连续的 1 和 2 进行分组，它将变成：
 * 
 *         1 22 11 2 1 22 1 22 11 2 11 22 ......
 * 
 *         并且每个组中 '1' 或 '2' 的出现次数分别是：
 * 
 *         1 2 2 1 1 2 1 2 2 1 2 2 ......
 * 
 *         你可以看到上面的出现次数就是 S 本身。
 * 
 *         给定一个整数 N 作为输入，返回神奇字符串 S 中前 N 个数字中的 '1' 的数目。
 * 
 *         注意：N 不会超过 100,000。
 * 
 *         示例：
 * 
 *         输入：6 输出：3 解释：神奇字符串 S 的前 6 个元素是 “12211”，它包含三个 1，因此返回 3。
 * 
 *         来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/magical-string
 *         著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MagicalString481 {
	public int magicalString(int n) {
		if (n <=0) {
			return 0;
		}
		if (n < 4) {
			return 1;
		}
		int sum = 1;
		int ind = 2;
		int leng = 3;
		StringBuffer sb = new StringBuffer("122");
		while (leng < n) {
			int order = sb.charAt(ind) - '0';
			int last = sb.charAt(leng - 1) - '0';
			if (order == 1 && last == 1) {
				sb.append("2");
			} else if (order == 1 && last == 2) {
				sb.append("1");
				sum += 1;
			} else if (order == 2 && last == 1) {
				sb.append("22");
			} else if (order == 2 && last == 2) {
				sb.append("11");
				sum += 2;
			}
			leng += order;
			ind++;
		}
		if (leng > n && sb.charAt(leng - 1) - '0' == 1) {
			sum -= 1;
		}
		return sum;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
