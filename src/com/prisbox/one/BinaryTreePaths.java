/**
 * 
 */
package com.prisbox.one;

import java.util.ArrayList;
import java.util.List;

import com.prisbox.base.TreeNode;

/**
 * @author admin
 *
 */
public class BinaryTreePaths {
	public List<String> binaryTreePaths(TreeNode root) {
		if(root==null){
			return new ArrayList<>();
		}
        List<String> result = new ArrayList<String>();
        help("",result,root);
        return result;
    }
	
	private void help(String l,List<String>r,TreeNode root){
		if(root.left==null&&root.right==null){
			r.add(l+root.val);
			return;
		}
		if(root.left!=null){
			help(l+root.val+"->",r,root.left);
		}
		if(root.right!=null){
			help(l+root.val+"->",r,root.right);
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
