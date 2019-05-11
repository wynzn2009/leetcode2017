/**
 * 
 */
package com.prisbox.one;

import java.util.HashMap;
import java.util.Map;

import com.prisbox.base.TreeNode;

/**
 * @author admin
 *
 */
public class Rob {
	public int rob(TreeNode root) {
		Map<TreeNode, Package> map = new HashMap<>();
		help(root,map);
		Package p = map.get(root);
		if(p==null){
			return 0;
		}
		return Math.max(p.getMax(), p.getMax_above());
	}

	private void help(TreeNode root, Map<TreeNode, Package> map) {
		if (root == null) {
			return;
		}
		help(root.left,map);
		help(root.right,map);
		Package p = new Package(0, 0);
		Package left = map.get(root.left);
		Package right = map.get(root.right);
		if (left == null) {
			left = new Package(0, 0);
		}
		if (right == null) {
			right = new Package(0, 0);
		}
		p.setMax(Math.max(left.getMax(), left.getMax_above())+Math.max(right.getMax(), right.getMax_above()));
		p.setMax_above(left.getMax() + root.val+right.getMax());
		map.put(root, p);
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}
}

class Package {
	private int max;
	private int max_above;

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getMax_above() {
		return max_above;
	}

	public void setMax_above(int max_above) {
		this.max_above = max_above;
	}

	public Package(int max, int max_above) {
		super();
		this.max = max;
		this.max_above = max_above;
	}

}