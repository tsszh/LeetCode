package LT100T150;

import java.util.HashMap;
import java.util.Map;

import utilities.RandomListNode;

/**
 * 138. Copy List with Random Pointer
 * 
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 * 
 * A linked list is given such that each node contains an additional random
 * pointer which could point to any node in the list or null. Return a deep copy
 * of the list.
 * 
 * Related: 133 - Clone Graph ( https://leetcode.com/problems/clone-graph/ )
 * 
 * @author Zehao
 *
 */

public class LT138 {
	/**
	 * 
	 * Hash Map Method Old - ABCD New - abcd Use a map to record the node pairs:
	 * (Aa) (Bb) (Cc) (Dd)
	 * 
	 * Time: O(n); Space: O(n)
	 * 
	 * @param head
	 *            The first node of the original linked list
	 * @return
	 */
	public RandomListNode copyRandomList1(RandomListNode head) {
		if (head == null)
			return null;

		RandomListNode newHead = new RandomListNode(head.label);
		Map<RandomListNode, RandomListNode> map = new HashMap<>();

		// Copy LinkedList without setting random pointer
		for (RandomListNode op = head, np = newHead; op != null; op = op.next, np = np.next) {
			map.put(op, np);
			if (op.next != null) {
				np.next = new RandomListNode(op.next.label);
			}
		}
		// Set random pointer
		for (RandomListNode op = head, np = newHead; op != null; op = op.next, np = np.next) {
			if (op.random != null) {
				np.random = map.get(op.random);
			}
		}
		return newHead;
	}

	/**
	 * 
	 * Old - ABCD New - abcd Use the next pointer to link all nodes together:
	 * AaBbCcDd
	 * 
	 * Time: O(n); Space: O(1)
	 * 
	 * @param head
	 *            The first node of the original linked list
	 * @return
	 */
	public RandomListNode copyRandomList2(RandomListNode head) {
		if (head == null)
			return null;

		RandomListNode newHead = new RandomListNode(head.label);
		// Copy LinkedList without setting random pointer
		for (RandomListNode op = head, np = newHead, temp; op != null;) {
			if (op.next != null) {
				np.next = new RandomListNode(op.next.label);
				temp = np.next;
				np.next = op.next;
				op.next = np;

				op = np.next;
				np = temp;
			} else {
				op.next = np; // Clean up the last node pair
				op = null;
			}
		}
		// Set random pointer
		for (RandomListNode op = head, np = newHead; op != null;) {
			if (op.random != null) {
				np.random = op.random.next;
			}
			op = np.next;
			if (op != null)
				np = op.next;
		}
		// Restore the original linked list
		for (RandomListNode op = head, np = newHead; op != null;) {
			op.next = np.next;
			if (np.next != null)
				np.next = np.next.next;

			op = op.next;
			np = np.next;
		}
		return newHead;
	}
}
