package utilities;

/**
 * Definition for singly-linked list.
 * @author Zehao
 *
 */
public class ListNode {
	public int val;
	public ListNode next;
	public ListNode(int x) {
		val = x;
		next = null;
	}
	
	/*
	 * Self-defined methods
	 */
	@Override
	public String toString() {
		return ""+val;
	}
}