/**
 * 
 */
package com.prisbox.one;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author 015422404 我们有一些二维坐标，如 "(1, 3)" 或 "(2,
 *         0.5)"，然后我们移除所有逗号，小数点和空格，得到一个字符串S。返回所有可能的原始字符串到一个列表中。
 * 
 *         原始的坐标表示法不会存在多余的零，所以不会出现类似于"00", "0.0", "0.00", "1.0", "001",
 *         "00.01"或一些其他更小的数来表示坐标。此外，一个小数点前至少存在一个数，所以也不会出现“.1”形式的数字。
 * 
 *         最后返回的列表可以是任意顺序的。而且注意返回的两个数字中间（逗号之后）都有一个空格。
 * 
 *          
 * 
 *         示例 1: 输入: "(123)" 输出: ["(1, 23)", "(12, 3)", "(1.2, 3)", "(1, 2.3)"]
 *         示例 2: 输入: "(00011)" 输出:  ["(0.001, 1)", "(0, 0.011)"] 解释: 0.0, 00,
 *         0001 或 00.01 是不被允许的。 示例 3: 输入: "(0123)" 输出: ["(0, 123)", "(0, 12.3)",
 *         "(0, 1.23)", "(0.1, 23)", "(0.1, 2.3)", "(0.12, 3)"] 示例 4: 输入:
 *         "(100)" 输出: [(10, 0)] 解释: 1.0 是不被允许的。  
 * 
 *         提示:
 * 
 *         4 <= S.length <= 12. S[0] = "(", S[S.length - 1] = ")",
 *         且字符串 S 中的其他元素都是数字。
 * 
 *         来源：力扣（LeetCode）
 *         链接：https://leetcode-cn.com/problems/ambiguous-coordinates
 *         著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AmbiguousCoordinates816 {
	public static List<String> ambiguousCoordinates(String s) {

		List<String> re = new ArrayList<String>();
		String S = s.replace("(", "").replace(")", "");
		boolean[] zero = new boolean[S.length()];
		for (int i = 0; i < S.length(); i++) {
			zero[i] = S.charAt(i) == '0';
		}
		for (int i = 1; i < S.length(); i++) {
			List<String> left = help(S, 0, i-1, zero);
			if (left.size() == 0) {
				continue;
			}
			List<String> right = help(S, i, S.length()-1, zero);
			if (right.size() == 0) {
				continue;
			}
			for (String le : left) {
				for (String ri : right) {
					re.add("(" + le + ", " + ri + ")");
				}
			}
		}
		return re;
	}

	private static List<String> help(String s, int start, int end, boolean[] zero) {
		List<String> re = new ArrayList<>();
		boolean startWithZero = zero[start];
		boolean endWithZero = zero[end];
		if (!endWithZero) {
			for (int i = start + 1; i <= end; i++) {
				if (startWithZero) {
					StringBuilder sb = new StringBuilder();
					sb.append(s.charAt(start)).append(".").append(s.substring(start + 1, end+1));
					re.add(sb.toString());
					break;
				} else {
					StringBuilder sb = new StringBuilder();
					sb.append(s.substring(start, i)).append(".").append(s.substring(i, end+1));
					re.add(sb.toString());
				}
			}
		}
		if (!startWithZero) {
			re.add(s.substring(start, end+1));
		} else if (startWithZero && start == end) {
			re.add("0");
		}

		return re;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "(123)";
		System.out.println(AmbiguousCoordinates816.ambiguousCoordinates(s));
	}

}
