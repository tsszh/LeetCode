package LT100T150;

import utilities.ListNode;

/**
 * 147. Insertion Sort List 
 * 
 * Sort a linked list using insertion sort.
 * 1->4->3->2 to 1->2->3->4
 * 
 * Similar Problems: 148. Sort List
 * 
 * @author Zehao
 *
 */
public class LT147 {
	public ListNode insertionSortList(ListNode head) {
		ListNode dummy = new ListNode( Integer.MIN_VALUE );
		dummy.next = head;
		ListNode prev = dummy, curr = head;
		while ( curr != null ) {
			if ( prev.val <= curr.val ) {
				prev = curr; curr = curr.next;
			} else {
				ListNode p = dummy;
				while ( p.val < curr.val && p.next.val < curr.val ) {
					p = p.next;
				}
				prev.next = curr.next;
				curr.next = p.next;
				p.next = curr;
				curr = prev.next;
			}
		}
		return dummy.next;
	}
}
