package LT200T250;

import utilities.ListNode;

/**
 * 206. Reverse Linked List
 * 
 * Reverse a singly linked list.
 * 
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * 
 * Similar Problems: 92. Reverse Linked List II
 * 					 156. Binary Tree Upside Down
 * 					 234. Palindrome Linked List
 */
public class LT206 {
	public ListNode reverseList2(ListNode head) {
		ListNode prev = null, curr = head;
		while (curr != null) {
			ListNode tmp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = tmp;
		}
		return prev;
    }
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) return head;
		ListNode newHead = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return newHead;
	}
}
