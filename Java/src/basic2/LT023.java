package basic2;

import java.util.*;
import java.io.*;

public class LT023 {
	public static void main ( String[] args ) throws FileNotFoundException {
		Scanner in = new Scanner(new File("c:/Users/ZSong/Desktop/test.txt"));
		List<ListNode> lists = new ArrayList<ListNode>();
		while ( in.hasNextLine() ) {
			ListNode head=null, curr=null;
			if ( in.hasNextInt() ) {
				head = new ListNode(in.nextInt());
				curr = head;
				while ( in.hasNextInt() ) {
					curr.next = new ListNode(in.nextInt());
					curr = curr.next;
				}
				lists.add(head);
			} else {
				lists.add(null);
			}
			in.nextLine();
		}
		System.out.println(lists);
		ListNode ans;
		long st = System.nanoTime();
		ans = mergeKLists(lists.toArray(new ListNode[0]));
		long et = System.nanoTime();
		System.out.println("Time = "+(et-st));
		System.out.println(ans);
		in.close();
	}
	/**
	 * Implemented via PriorityQueue(Heap)
	 * Time : O(nlgk) Space : k
	 * @param lists
	 * @return
	 */
	public static ListNode mergeKLists(ListNode[] lists) {
		if ( lists.length == 0 ) return null;
		PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(lists.length,
				new Comparator<ListNode>() {
					public int compare(ListNode a, ListNode b) {
						return a.val-b.val;
					}
				});
		for ( int i = 0; i<lists.length; i++ ) {
			if ( lists[i] != null ) {
				heap.add(lists[i]);
			}
		}
		ListNode head=new ListNode(0), curr=head;
		while ( !heap.isEmpty() ) {
			curr.next = heap.poll();
			curr = curr.next;
			if ( curr.next != null ) {
				heap.add(curr.next);	
			}
		}
		return head.next;
    }
	public static ListNode mergeKLists2(ListNode[] lists) {
		if ( lists.length == 0 ) return null;
		int n = lists.length;
		while ( n > 1 ) {
			int j, i;
			for ( i = 1, j=0; i<n; i+=2,j++ ) {
				 lists[j]= mergeTwoList(lists[i-1],lists[i]);
			}
			if ( n%2 == 1 ) lists[j] = lists[n-1];
			n = (n-1)/2+1;
		}
		return lists[0];
	}
	private static ListNode mergeTwoList(ListNode l1, ListNode l2) {
		if ( l1 == null ) return l2;
		if ( l2 == null ) return l1;
		if ( l1.val < l2.val ) {
			l1.next = mergeTwoList(l1.next,l2);
			return l1;
		} else {
			l2.next = mergeTwoList(l1,l2.next);
			return l2;
		}
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