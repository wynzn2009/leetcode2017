/**
 * 
 */
package com.prisbox.one;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 015422404 给定仅有小写字母组成的字符串数组
 *         A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4
 *         次，则需要在最终答案中包含该字符 3 次。
 * 
 *         你可以按任意顺序返回答案。
 * 
 *          
 * 
 *         示例 1：
 * 
 *         输入：["bella","label","roller"] 输出：["e","l","l"] 示例 2：
 * 
 *         输入：["cool","lock","cook"] 输出：["c","o"]
 * 
 */
public class FindCommonCharacters1002 {
	public List<String> commonChars(String[] A) {
		char[][] c = new char[A.length][26];
		for (int i = 0; i < A.length; i++) {
			String a = A[i];
			for (int j = 0; j < a.length(); j++) {
				c[i][a.charAt(j) - 'a']++;
			}
		}
		List<String> l = new ArrayList<String>();
		for (int i = 0; i < 26; i++) {
			int count = Integer.MAX_VALUE;
			for (int j = 0; j < A.length; j++) {
				count = Math.min(count, c[j][i]);
			}
			for (int k = 0; k < count; k++) {
				l.add(String.valueOf((char)('a' + i)));
			}
		}
		return l;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
