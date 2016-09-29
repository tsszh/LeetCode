package LT050T100;

import utilities.ListNode;

/**
 * 61. Rotate List
 * 
 * Given a list, rotate the list to the right by k places, where k is
 * non-negative.
 * 
 * For example: Given 1->2->3->4->5->NULL and k = 2, return 4->5->1->2->3->NULL.
 * 
 * Similar Problems: 189. Rotate Array
 * @author Zehao
 *
 */
public class LT61 {
	public ListNode rotateRight(ListNode head, int k) {
		int n = 0;
		ListNode tail = null;
		for (ListNode pt = head; pt != null; pt = pt.next) {
			n++;
			tail = pt;
		}
		if (n <= 1)
			return head;
		if (k % n == 0)
			return head;
		ListNode prev = null, curr = head;
		for (int i = n - k % n; i > 0; i--) {
			prev = curr;
			curr = curr.next;
		}
		prev.next = null;
		tail.next = head;
		return curr;
	}
}
