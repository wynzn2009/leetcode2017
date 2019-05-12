/**
 * 
 */
package com.prisbox.one;

import com.prisbox.base.TreeNode;

/**
 * @author LO
 *
 */
public class BinarySearchTreetoGreaterSumTree1038 {
	public static TreeNode bstToGst(TreeNode root) {
		TreeNode re = new TreeNode(0);
		build(re, root);
		help(re, root, 0);
		return re;
	}

	private static void build(TreeNode re, TreeNode ro) {
		if(ro==null) {
			return;
		}
		if(ro.left!=null) {
			re.left = new TreeNode(0);
			build(re.left, ro.left);
		}
		if(ro.right!=null) {
			re.right = new TreeNode(0);
			build(re.right, ro.right);
		}
	}

	/**
	 * 返回一棵树所有节点的和
	 * 
	 * @param re
	 * @param root
	 * @return
	 */
	private static int help(TreeNode re, TreeNode root, int val) {
		if (root == null) {
			return val;
		}
		int right = help(re.right, root.right, val);
		re.val = root.val + right;
		int left = help(re.left, root.left, re.val);

		return left;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode re = new TreeNode(4);
		re.left = new TreeNode(1);
		re.right = new TreeNode(6);

		re.left.left = new TreeNode(0);
		re.left.right = new TreeNode(2);
		re.left.right.right = new TreeNode(3);

		re.right.left = new TreeNode(5);
		re.right.right = new TreeNode(6);
		re.right.right.right = new TreeNode(8);
		BinarySearchTreetoGreaterSumTree1038.bstToGst(re);
	}

}
