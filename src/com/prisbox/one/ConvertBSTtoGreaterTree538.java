/**
 * 
 */
package com.prisbox.one;

import java.util.ArrayList;
import java.util.List;

import com.prisbox.base.TreeNode;

/**
 * @author LO 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater
 *         Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 * 
 *          
 * 
 *         例如：
 * 
 *         输入: 原始二叉搜索树: 5 / \ 2 13
 * 
 *         输出: 转换为累加树: 18 / \ 20 13
 * 
 *         来源：力扣（LeetCode）
 *         链接：https://leetcode-cn.com/problems/convert-bst-to-greater-tree
 *         著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ConvertBSTtoGreaterTree538 {
	List<TreeNode> list = new ArrayList<TreeNode>();

	public TreeNode convertBST(TreeNode root) {
		if (root == null) {
			return root;
		}
		help(root);
		int temp = 0;
		for (TreeNode node : list) {
			node.val += temp;
			temp = node.val;
		}
		return root;
	}

	public void help(TreeNode root) {
		if (root == null) {
			return;
		}
		help(root.right);
		list.add(root);
		help(root.left);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
