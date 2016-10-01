package LT200T250;

import utilities.ListNode;

/**
 * 203. Remove Linked List Elements Remove all elements from a linked list of
 * integers that have value val.
 * 
 * Example
 * 
 * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 * 
 * Return: 1 --> 2 --> 3 --> 4 --> 5
 * 
 * Similar Problems: 27. Remove Element
 * 					 237. Delete Node in a Linked List
 * 
 * @author Zehao
 *
 */
public class LT203 {
	public ListNode removeElements(ListNode head, int val) {
		ListNode prev = null, curr = head;
		while (curr != null) {
			if (curr.val == val) {
				if (prev == null) {
					head = curr.next;
				} else {
					prev.next = curr.next;
				}
				curr = curr.next;
			} else {
				prev = curr;
				curr = curr.next;
			}
		}
		return head;
	}
}
