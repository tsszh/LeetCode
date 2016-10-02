package LT050T100;

import utilities.ListNode;

/**
 * 92. Reverse Linked List II
 * 
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * 
 * For example: 
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * 
 * return 1->4->3->2->5->NULL.
 * 
 * Note: Given m, n satisfy the following condition: 1 ≤ m ≤ n ≤ length of list.
 * 
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * 
 * Similar Problems: 206. Reverse Linked List
 * 
 * @author Zehao
 *
 */
public class LT092 {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		// Find ptM
		ListNode ptM_prev = null, ptM = head;
		for (int i = 2; i <= m; i++) {
			ptM_prev = ptM;
			ptM = ptM.next;
		}
		// Find ptN
		ListNode ptN = ptM;
		for (int i = m + 1; i <= n; i++) {
			ptN = ptN.next;
		}
		ListNode ptN_next = ptN.next;
		// Reverse LinkedList between ptM, ptN
		ptN.next = null;
		reverse(ptM);
		// Connect Tail
		ptM.next = ptN_next;
		// Connect Head
		if (ptM_prev != null) {
			ptM_prev.next = ptN;
		} else {
			head = ptN;
		}
		return head;

	}

	private ListNode reverse(ListNode head) {
		ListNode prev = null, curr = head;
		while (curr != null) {
			ListNode tmp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = tmp;
		}
		return prev;
	}
}
