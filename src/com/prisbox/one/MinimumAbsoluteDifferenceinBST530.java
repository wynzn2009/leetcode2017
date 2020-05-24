/**
 * 
 */
package com.prisbox.one;

import java.util.ArrayList;
import java.util.List;

import com.prisbox.base.TreeNode;

/**
 * @author LO 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 * 
 *          
 * 
 *         示例：
 * 
 *         输入：
 * 
 *         1 \ 3 / 2
 * 
 *         输出： 1
 * 
 *         解释： 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 * 
 *         来源：力扣（LeetCode）
 *         链接：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst
 *         著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinimumAbsoluteDifferenceinBST530 {
	int min = Integer.MAX_VALUE;

	public int getMinimumDifference(TreeNode root) {
		List<Integer> list = new ArrayList();
		help(root, list);
		return min;
	}

	public void help(TreeNode root, List<Integer> list) {
		if (root == null) {
			return;
		}
		help(root.left, list);

		if (!list.isEmpty()) {
			min = Math.min(min, Math.abs(root.val - list.get(list.size() - 1)));
		}
		list.add(root.val);
		help(root.right, list);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
