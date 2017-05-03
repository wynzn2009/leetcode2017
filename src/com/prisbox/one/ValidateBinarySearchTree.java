/**
 * 
 */
package com.prisbox.one;

import com.prisbox.base.TreeNode;

/**
 * @author admin
 *
 */
public class ValidateBinarySearchTree {
	private long n = Long.MIN_VALUE;
	public boolean isValidBST(TreeNode root) {
		if(null == root){
			return true;
		}
        return f(root);
    }
	
	private boolean f(TreeNode root){
		if(root==null){
			return true;
		}
		if(!f(root.left)){
			return false;
		}
		if(root.val<=n){
			return false;
		}else{
			n = root.val;
		}
		if(!f(root.right)){
			return false;
		}
		return true;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidateBinarySearchTree v = new ValidateBinarySearchTree();
		TreeNode n = new TreeNode(1);
		n.left = new TreeNode(1);
		v.isValidBST(n);
	}

}
