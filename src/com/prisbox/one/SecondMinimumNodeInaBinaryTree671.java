/**
 * 
 */
package com.prisbox.one;

import com.prisbox.base.TreeNode;

/**
 * @author LO 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或
 *         0。如果一个节点有两个子节点的话，那么这个节点的值不大于它的子节点的值。
 * 
 *         给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
 * 
 *         示例 1:
 * 
 *         输入: 2 / \ 2 5 / \ 5 7
 * 
 *         输出: 5 说明: 最小的值是 2 ，第二小的值是 5 。 示例 2:
 * 
 *         输入: 2 / \ 2 2
 * 
 *         输出: -1 说明: 最小的值是 2, 但是不存在第二小的值。
 */
public class SecondMinimumNodeInaBinaryTree671 {
	public int findSecondMinimumValue(TreeNode root) {
		if (root == null) {
			return -1;
		}
		int first = root.val;
		int a = help(root.left, first);
		int b = help(root.right, first);
		if (a != -1 && b != -1) {
			return Math.min(a, b);
		} else if (a == -1) {
			return b;
		} else {
			return a;
		}
	}

	private int help(TreeNode root, int first) {
		if (root == null) {
			return -1;
		}
		if (root.val > first) {
			return root.val;
		} else {
			int a = help(root.left, first);
			int b = help(root.right, first);
			if (a != -1 && b != -1) {
				return Math.min(a, b);
			} else if (a == -1) {
				return b;
			} else {
				return a;
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
