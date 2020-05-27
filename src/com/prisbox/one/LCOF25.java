/**
 * 
 */
package com.prisbox.one;

import com.prisbox.base.ListNode;

/**
 * @author LO 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * 
 *         示例1：
 * 
 *         输入：1->2->4, 1->3->4 输出：1->1->2->3->4->4 限制：
 * 
 *         0 <= 链表长度 <= 1000
 * 
 *         来源：力扣（LeetCode）
 *         链接：https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof
 *         著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LCOF25 {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode root = new ListNode(0);
		ListNode tail = root;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				tail.next = l1;
				tail = tail.next;
				l1 = l1.next;
			} else {
				tail.next = l2;
				tail = tail.next;
				l2 = l2.next;
			}
		}
		if (l1 != null) {
			tail.next = l1;
		}
		if (l2 != null) {
			tail.next = l2;
		}
		return root.next;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
