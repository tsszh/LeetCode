package LT150T200;

import utilities.ListNode;

public class LT160 {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode p1 = headA, p2 = headB;
		int endCount = 0;
		while ( p1 != p2 ) {
			if ( p1 == null ) {
				p1 = headB;
				if ( ++endCount > 2 ) return null;
			} else {
				p1 = p1.next;
			}
			if ( p2 == null ) {
				p2 = headA;
				if ( ++endCount > 2 ) return null;
			} else {
				p2 = p2.next;
			}
		}
		return p1;
	}
}
