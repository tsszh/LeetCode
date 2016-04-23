package LT100T150;

import utilities.ListNode;

/**
 * 142. Linked List Cycle II (Floyd's Cycle Detection Algorithm)
 * 
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * 
 * Note: Do not modify the linked list.
 * 
 * Follow up: Can you solve it without using extra space?
 * 
 * Similar Problems: 141. Linked List Cycle
 * 					 287. Find the Duplicate Number
 * @author Zehao
 *
 */
public class LT142 {
	/**
	 * Floyd's Algorithm
	 * 
	 * @param head
	 * @return
	 */
	public ListNode detectCycle(ListNode head) {
		ListNode fast = head, slow = head;
		while ( fast != null && fast.next != null ) {
			fast = fast.next.next;
			slow = slow.next;
			if ( fast == slow ) {
				slow = head;
				while ( fast != slow ) {
					fast = fast.next;
					slow = slow.next;
				}
				return fast;
			}
		}
		return null;
	}
}
