/**
 * 
 */
package com.prisbox.one;

import java.util.LinkedList;

import com.prisbox.base.TreeNode;

/**
 * @author 015422404 给出一个完全二叉树，求出该树的节点个数。
 * 
 *         说明：
 * 
 *         完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第
 *         h 层，则该层包含 1~ 2h 个节点。
 * 
 *         示例:
 * 
 *         输入: 1 / \ 2 3 / \ / 4 5 6
 * 
 *         输出: 6
 * 
 * 
 */
public class CountCompleteTreeNodes222 {
	public int countNodes(TreeNode root) {
		if (root == null) {
			return 0;
		}
		LinkedList<TreeNode> l = new LinkedList<>();
		l.add(root);
		int sum = 0;
		while (!l.isEmpty()) {
			TreeNode r = l.poll();
			sum++;
			if (r.left != null) {
				l.add(r.left);
			}
			if (r.right != null) {
				l.add(r.right);
			}
		}
		return sum;
	}
	public int countNodes1(TreeNode root) {
        if(root==null)
            return 0;
        
        int l = countNodes(root.left);
        int r = countNodes(root.right);
        
        return l+r+1;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
