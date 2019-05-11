/**
 * 
 */
package com.prisbox.one;

import java.util.LinkedList;

import com.prisbox.base.TreeNode;

/**
 * @author LO
 *
 */
public class FindBottomLeftTreeValue {
	public int findBottomLeftValue(TreeNode root) {
		LinkedList<TreeNode> list = new LinkedList<TreeNode>();
		list.offerLast(root);
		TreeNode node = null;
		while (!list.isEmpty()) {
			node = list.pollFirst();
			if (node.right != null) {
				list.offerLast(node.right);
			}
			if (node.left != null) {
				list.offerLast(node.left);
			}
		}
		return node.val;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

}
