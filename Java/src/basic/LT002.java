package basic;

public class LT002 {
	 public static void main ( String[] args ) {
		 int n1 = 5;
		 int n2 = 5;
		 ListNode l1 = ListNode.intToList(n1);
		 ListNode l2 = ListNode.intToList(n2);
		 System.out.println(l1+"+"+l2+"=");
		 System.out.println(addTwoNumbers(l1,l2));
	 }
	 public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		 ListNode ret = null, prev = null;
		 int extra = 0;
		 while ( l1 != null || l2 != null || extra != 0 ) {
			 int val = extra+(l1==null?0:l1.val) + (l2==null?0:l2.val);
			 extra = val/10;
			 if ( ret == null )
				 prev = ret = new ListNode( val%10 );
			 else {
				 prev.next = new ListNode( val%10 );
				 prev = prev.next;
			 }
			if ( l1 != null )
				 l1 = l1.next;
			 if ( l2 != null )
				 l2 = l2.next;
		 }
		 return ret;
	 }
}
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
	public static ListNode intToList(int n) {
		if ( n == 0 )
			return new ListNode(0);
		ListNode ret=null, curr=null;
		while (n!=0) {
			if ( ret == null ) {
				ret = new ListNode(n%10);;
				curr = ret;
			}
			else {
				curr.next = new ListNode(n%10);
				curr = curr.next;
			}
			n = n/10;
		}
		return ret;
	}
	public String toString() {
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
