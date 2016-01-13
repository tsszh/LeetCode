package Medium1;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; next = null; }
	public static ListNode createList( int[] nums ) {
		if ( nums == null || nums.length == 0 ) return null;
		ListNode head = new ListNode(nums[0]);
		ListNode curr = head;
		for ( int i = 1; i < nums.length; i++ ) {
			curr.next = new ListNode(nums[i]);
			curr = curr.next;
		}
		return head;
	}
	public String toString() {
		return ""+val;
	}
	public String deepToString() {
		StringBuilder str = new StringBuilder("["+val);
		ListNode curr = next;
		while ( curr != null )  {
			str.append("->"+curr.val);
			curr = curr.next;
		}
		str.append("]");
		return str.toString();
	}
}