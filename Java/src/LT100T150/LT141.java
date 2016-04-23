package LT100T150;

import utilities.ListNode;

/**
 * 141. Linked List Cycle (Floyd's Cycle Detection Algorithm)
 * 
 * Given a linked list, determine if it has a cycle in it.
 * 
 * Follow up:
 * Can you solve it without using extra space?
 * 
 * Similar Problem: 142. Linked List Cycle II
 * @author Zehao
 *
 */
public class LT141 {
	/**
	 * Floyd's Cycle Detection Algorithm
	 * 
	 * Fast-Slow Two pointer method
	 * Time: O(n) Space: O(1)
	 * @param head
	 * @return
	 */
	public boolean hasCycle(ListNode head) {
		ListNode fast=head, slow=head;
		while ( fast!=null && fast.next!=null ) {
			fast = fast.next.next;
			slow = slow.next;
			if ( fast == slow ) return true;
		}
		return false;
	}
	
	/**
	 * Reverse LinkedList Method
	 * Time: O(n) Space: O(1)
	 * @param head
	 * @return
	 */
	public boolean hasCycle2(ListNode head) {
		if ( head == null ) return false;
		ListNode prev=head, temp=null, next=prev.next;
		while ( next != null ) {
			if ( next == head ) return true;
			temp = next;
			next = temp.next;
			temp.next = prev;
			prev = temp;
		}
		return false;
	}
}
