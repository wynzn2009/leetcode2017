/**
 * 
 */
package com.prisbox.one;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.prisbox.base.Node;

/**
 * @author LO 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 * 
 *         例如，给定一个 3叉树 :
 * 
 *          
 * 
 * 
 * 
 *          
 * 
 *         返回其层序遍历:
 * 
 *         [ [1], [3,2,4], [5,6] ]  
 * 
 *         说明:
 * 
 *         树的深度不会超过 1000。 树的节点总数不会超过 5000。
 * 
 *         来源：力扣（LeetCode）
 *         链接：https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal
 *         著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NaryTreeLevelOrderTraversal429 {
	public List<List<Integer>> levelOrder(Node root) {
		List<List<Integer>> re = new ArrayList<>();
		if (root == null) {
			return re;
		}
		LinkedList<Node> list = new LinkedList<Node>();
		list.add(root);
		while (!list.isEmpty()) {
			List<Integer> l = new ArrayList<>();
			LinkedList<Node> list1 = new LinkedList<Node>();
			while (!list.isEmpty()) {
				Node nod = list.poll();
				l.add(nod.val);
				list1.addAll(nod.children);
			}
			re.add(l);
			list = list1;
		}

		return re;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
