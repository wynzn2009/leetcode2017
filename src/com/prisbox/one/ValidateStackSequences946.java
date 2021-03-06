/**
 * 
 */
package com.prisbox.one;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author wynzn 给定 pushed 和 popped 两个序列，每个序列中的 值都不重复，只有当它们可能是在最初空栈上进行的推入 push
 *         和弹出 pop 操作序列的结果时，返回 true；否则，返回 false 。
 * 
 *          
 * 
 *         示例 1：
 * 
 *         输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1] 输出：true 解释：我们可以按以下顺序执行：
 *         push(1), push(2), push(3), push(4), pop() -> 4, push(5), pop() -> 5,
 *         pop() -> 3, pop() -> 2, pop() -> 1 示例 2：
 * 
 *         输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2] 输出：false 解释：1 不能在 2
 *         之前弹出。  
 * 
 *         提示：
 * 
 *         0 <= pushed.length == popped.length <= 1000 0 <= pushed[i], popped[i]
 *         < 1000 pushed 是 popped 的排列。
 * 
 *         来源：力扣（LeetCode）
 *         链接：https://leetcode-cn.com/problems/validate-stack-sequences
 *         著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ValidateStackSequences946 {
	public static boolean validateStackSequences(int[] pushed, int[] popped) {
		if (pushed.length == 0 && popped.length == 0) {
			return true;
		}
		LinkedList<Integer> list = new LinkedList<Integer>();
		int ind = 0;
		for (int i = 0; i < popped.length; i++) {
			if (ind < pushed.length && pushed[ind] == popped[i]) {
				ind++;
				continue;
			}
			while (ind < pushed.length) {
				if (!list.isEmpty() && list.peekFirst() == popped[i]) {
					list.pop();
					break;
				} else {
					list.push(pushed[ind++]);
				}
			}
			if (ind >= pushed.length && list.peekFirst() != popped[i]) {
				return false;
			} else if (ind >= pushed.length && list.peekFirst() == popped[i]) {
				list.pop();
			}
		}
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] pushed = { 1, 2, 3, 4, 5 };
		int[] popped = { 4, 5, 3, 2, 1 };
		// TODO Auto-generated method stub
		ValidateStackSequences946.validateStackSequences(pushed, popped);
	}

}
