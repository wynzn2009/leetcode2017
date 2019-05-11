/**
 * 
 */

package com.prisbox.one;

import java.util.ArrayList;
import java.util.List;

import com.prisbox.base.TreeNode;

/**
 * @author LO
 *
 */
public class LeafSimilar872 {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        help(root1, list1);
        help(root2, list2);
        if (list1.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i) != list2.get(i)) {
                return false;
            }
        }
        return true;
    }

    private void help(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        help(root.left, list);
        help(root.right, list);
        if (root.left == null && root.right == null) {
            list.add(root.val);
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

    }

}
