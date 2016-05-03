package LT100T150;

import utilities.ListNode;

/**
 * 
 * 148. Sort List 
 * 
 * Sort a linked list in O(n log n) time using constant space complexity.
 *  1->4->3->2 to 1->2->3->4
 *  
 *  
 * Similar Problems: 21. Merge Two Sorted Lists
 * 					 75. Sort Colors
 * 					 147. Insertion Sort List 
 * 
 * @author Zehao
 *
 */
public class LT148 {
	/*
	 * 
	 * Merge Sort
	 * 
	 */
	public ListNode sortList(ListNode head) {
		if ( head == null || head.next == null ) return head;
		ListNode fast = head, slow = head;
		while ( fast != null && fast.next != null && fast.next.next != null ) {
			slow = slow.next; 
			fast = fast.next.next;
		}
		fast = slow.next;
		slow.next = null;
		return merge( sortList(head), sortList(fast) );
	}
	
	private ListNode merge( ListNode a, ListNode b ) {
		if ( b == null ) return a;
		if ( a == null ) return b;
		if ( a.val > b.val ) return merge(b,a);
		ListNode head = a;
		while ( b != null ) {
			while ( a.next != null && a.val < b.val && a.next.val < b.val ) {
				a = a.next;
			}
			if ( a.next == null ) {				
				a.next = b;
				break;
			} else {
				ListNode temp = b.next;
				b.next = a.next;
				a.next = b;
				b = temp;
				a = a.next;
			}
		}
		return head;
	}
}
