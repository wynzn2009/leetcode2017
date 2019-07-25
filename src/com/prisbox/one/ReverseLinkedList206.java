/**
 * 
 */
package com.prisbox.one;

import com.prisbox.base.ListNode;

/**
 * @author 015422404 反转一个单链表。
 * 
 *         示例:
 * 
 *         输入: 1->2->3->4->5->NULL 输出: 5->4->3->2->1->NULL 进阶:
 *         你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * 
 */
public class ReverseLinkedList206 {
	public ListNode reverseList(ListNode head) {
		ListNode pre = null;
		ListNode cur = head;
		while(cur!=null) {
			ListNode tmp = cur.next;
			cur.next = pre;
			pre = cur;
			cur = tmp;
		}
		return pre;
		
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
