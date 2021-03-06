/**
 * 
 */
package com.prisbox.one;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LO 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
 * 
 *         示例: 输入: S = "a1b2" 输出: ["a1b2", "a1B2", "A1b2", "A1B2"]
 * 
 *         输入: S = "3z4" 输出: ["3z4", "3Z4"]
 * 
 *         输入: S = "12345" 输出: ["12345"] 注意：
 * 
 *         S 的长度不超过12。 S 仅由数字和字母组成。
 * 
 *         来源：力扣（LeetCode）
 *         链接：https://leetcode-cn.com/problems/letter-case-permutation
 *         著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LetterCasePermutation784 {
	List<String> re = new ArrayList<>();

	public List<String> letterCasePermutation(String S) {
		char[] ch = S.toCharArray();
		help(ch, 0);
		if (re.size() == 0) {
			re.add(S);
		}
		return re;
	}

	public void help(char[] ch, int index) {
		if (index >= ch.length) {
			re.add(String.valueOf(ch));
			return;
		}
		if (ch[index] > '9') {
			ch[index] = String.valueOf(ch[index]).toLowerCase().charAt(0);
			help(ch, index + 1);
			ch[index] = String.valueOf(ch[index]).toUpperCase().charAt(0);
			help(ch, index + 1);
		}else {
			help(ch, index + 1);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
