/**
 * 
 */
package com.prisbox.one;

import java.util.LinkedList;

/**
 * @author LO 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * 
 *         在 S 上反复执行重复项删除操作，直到无法继续删除。
 * 
 *         在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 * 
 *          
 * 
 *         示例：
 * 
 *         输入："abbaca" 输出："ca" 解释： 例如，在 "abbaca" 中，我们可以删除 "bb"
 *         由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa"
 *         可以执行重复项删除操作，所以最后的字符串为 "ca"。
 * 
 *         来源：力扣（LeetCode）
 *         链接：https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string
 *         著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveAllAdjacentDuplicatesInString1047 {
	public String removeDuplicates(String S) {
		LinkedList<Character> l = new LinkedList();
		char[] car = S.toCharArray();
		for (int i = 0; i < car.length; i++) {
			if (!l.isEmpty() && car[i] == l.peek()) {
				l.pop();
			} else {
				l.push(car[i]);
			}
		}
		String re = "";
		while (!l.isEmpty()) {
			re = l.pop() + re;
		}
		return re;
	}
	
	public String removeDuplicates1(String S) {
		int i=0;
        char[] res = S.toCharArray();
        char[] re = new char[S.length()];
        for(int j=0;j<res.length;j++,i++){
        	re[i] = res[j];
            if(i>0 && re[i]==re[i-1]){
                i -= 2;
            }
        }
        return new String(re, 0, i);
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
