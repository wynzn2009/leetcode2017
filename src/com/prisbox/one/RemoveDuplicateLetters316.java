/**
 * 
 */
package com.prisbox.one;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author LO
 *
 *         给定一个仅包含小写字母的字符串，去除字符串中重复的字母，使得每个字母只出现一次。需保证返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 * 
 *         示例 1:
 * 
 *         输入: "bcabc" 输出: "abc" 示例 2:
 * 
 *         输入: "cbacdcbc" 输出: "acdb"
 * 
 *         来源：力扣（LeetCode）
 *         链接：https://leetcode-cn.com/problems/remove-duplicate-letters
 *         著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveDuplicateLetters316 {
	public static String removeDuplicateLetters(String s) {
		int[] ab = new int[26];
		Stack<Character> st = new Stack<>();
		Set<Character> set = new HashSet<>();
		char[] ch = s.toCharArray();
		for(int i = 0; i < s.length(); i++) {
			char cur = ch[i];
			ab[cur-'a']++;
		}
		for (int i = 0; i < s.length(); i++) {
			char cur = ch[i];
			if (set.contains(cur)) {
				ab[cur-'a']--;
				continue;
			}
			while (!st.isEmpty() && st.peek() > cur && ab[st.peek()-'a']>0) {
				char c = st.pop();
				set.remove(c);
			}
			st.push(cur);
			set.add(cur);
			ab[cur-'a']--;
		}
		char[] re = new char[st.size()];
		for (int i = re.length - 1; i >= 0; i--) {
			re[i] = st.pop();
		}
		return String.valueOf(re);

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "bcabc";
		RemoveDuplicateLetters316.removeDuplicateLetters(a);
	}

}
