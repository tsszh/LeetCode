package Medium1;

public class LT092 {
	public static void main ( String[] args ) {
		int[] nums = new int[] {
			1,2,3,4,5,6,7	
		};
		ListNode head = ListNode.createList(nums);
		System.out.println(head.deepToString());
		head = reverseBetween(head,4,7);
		System.out.println(head.deepToString());
	}
	public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode prev=null, curr=head;
        int c = 1;
        while ( c < m ) {
            prev = curr;
            curr = curr.next;
            c++;
        }
        ListNode prevHead = prev;
        prev = curr;
        curr = curr.next;
        c++;
        while ( c <= n ) {
        	ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            c++;
        }
        if ( prevHead != null ) {
        	prevHead.next.next = curr;
            prevHead.next = prev;
        } else {
        	head.next = curr;
        	head = prev;
        }
        return head;
    }
}
