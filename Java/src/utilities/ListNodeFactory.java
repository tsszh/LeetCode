package utilities;

public class ListNodeFactory {
	/**
	 * Create a Linked List: 0->1->2->...->len-1
	 * @param len The length of the linked list
	 * @return The head of the linked list
	 */
	public static ListNode createListNode ( int len ) {
		if ( len <= 0 ) return null;
		ListNode head = new ListNode(0), curr = head;
		for ( int i = 1; i < len; i++ ) {
			curr.next = new ListNode(i);
			curr = curr.next;
		}
		return head;
	}
	
	/**
	 * Create a Linked List based on the value arrays
	 * @param vals The integer array of node values
	 * @return The head of the linked list
	 */
	public static ListNode creatListNode ( int[] vals ) {
		int len = vals.length;
		if ( len <= 0 ) return null;
		ListNode head = new ListNode(vals[0]), curr = head;
		for ( int i = 1; i < len; i++ ) {
			curr.next = new ListNode( vals[i] );
			curr = curr.next;
		}
		return head;
	}
	
	/**
	 * Convert a linked list to an array.
	 * 
	 * @param root
	 * @return
	 */
	public static int[] toArray( ListNode root ) {
		int n = 0;
		for (ListNode pt = root; pt != null; pt = pt.next) {
			n++;
		}
		int[] res = new int[n];
		n = 0;
		for (ListNode pt = root; pt != null; pt = pt.next) {
			res[n++] = pt.val;
		}
		return res;
	}
}
