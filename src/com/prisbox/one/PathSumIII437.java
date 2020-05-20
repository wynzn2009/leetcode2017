/**
 * 
 */
package com.prisbox.one;

import com.prisbox.base.TreeNode;

/**
 * @author LO 给定一个二叉树，它的每个结点都存放着一个整数值。
 * 
 *         找出路径和等于给定数值的路径总数。
 * 
 *         路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * 
 *         二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 * 
 *         示例：
 * 
 *         root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 * 
 *         10 / \ 5 -3 / \ \ 3 2 11 / \ \ 3 -2 1
 * 
 *         返回 3。和等于 8 的路径有:
 * 
 *         1. 5 -> 3 2. 5 -> 2 -> 1 3. -3 -> 11
 * 
 *         来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/path-sum-iii
 *         著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PathSumIII437 {
	public int sumP = 0;

	public int pathSum(TreeNode root, int sum) {
		if (root == null) {
			return 0;
		}
		sum(root, sum);
		pathSum(root.left, sum);
		pathSum(root.right, sum);
		return sumP;
	}

	public void sum(TreeNode root, int sum) {
		if (root == null) {
			return;
		}
		if (root.val == sum) {
			sumP++;
		}
		sum = sum - root.val;
		sum(root.left, sum);
		sum(root.right, sum);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
