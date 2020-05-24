/**
 * 
 */
package com.prisbox.one;

import java.util.ArrayList;
import java.util.List;

import com.prisbox.base.TreeNode;

/**
 * @author LO 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 * 
 *         假定 BST 有如下定义：
 * 
 *         结点左子树中所含结点的值小于等于当前结点的值 结点右子树中所含结点的值大于等于当前结点的值 左子树和右子树都是二叉搜索树 例如： 给定
 *         BST [1,null,2,2],
 * 
 *         1 \ 2 / 2 返回[2].
 * 
 *         提示：如果众数超过1个，不需考虑输出顺序
 * 
 *         进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
 * 
 *         来源：力扣（LeetCode）
 *         链接：https://leetcode-cn.com/problems/find-mode-in-binary-search-tree
 *         著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindModeinBinarySearchTree501 {
	public int[] findMode(TreeNode root) {
		if(root==null) {
			return new int[0];
		}
		int max = 0;
		List<Integer> set = new ArrayList<>();
		List<Integer> list = new ArrayList<Integer>();
		help(root, list);
		int temp = list.get(0);
		int size = 1;
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i) == temp) {
				size++;
			} else {
				if (size == max) {
					set.add(temp);
				} else if (size > max) {
					set.clear();
					set.add(temp);
					max = size;
				}
				temp = list.get(i);
				size = 1;
			}
		}
		if (size == max) {
			set.add(temp);
		} else if (size > max) {
			set.clear();
			set.add(temp);
			max = size;
		}
		int[] re = new int[set.size()];
		for (int i = 0; i < set.size(); i++) {
			re[i] = set.get(i);
		}
		return re;
	}

	public void help(TreeNode root, List<Integer> list) {
		if (root == null) {
			return;
		}
		help(root.left, list);
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
