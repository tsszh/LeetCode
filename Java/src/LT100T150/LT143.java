package LT100T150;

import utilities.ListNode;

/**
 * 143. Reorder List
 * 
 * Given a singly linked list L: L0¡úL1¡ú¡­¡úLn-1¡úLn, 
 * reorder it to:                L0¡úLn¡úL1¡úLn-1¡úL2¡úLn-2¡ú¡­
 * 
 * You must do this in-place without altering the nodes' values.
 * 
 * For example, Given {1,2,3,4}, reorder it to {1,4,2,3}.
 * 
 * @author Zehao
 *
 */
public class LT143 {
	public void reorderList(ListNode head) {
		if (head == null)
			return;
		ListNode fast = head, slow = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode head2 = slow.next;
		slow.next = null;

		head2 = reverseLinkedList(head2);

		mergeLinkedList(head, head2);
	}

	private ListNode reverseLinkedList(ListNode head) {
		ListNode prev = null, next = head, temp;
		while (next != null) {
			temp = next;
			next = next.next;
			temp.next = prev;
			prev = temp;
		}
		return prev;
	}

	// len(head1) >= len(head2)
	private void mergeLinkedList(ListNode head1, ListNode head2) {
		while (head2 != null) {
			ListNode temp = head1.next;
			head1.next = head2;
			head1 = temp;
			temp = head2;
			head2 = head2.next;
			temp.next = head1;
		}
	}
}
