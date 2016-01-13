package basic2;

import java.util.*;
import java.io.*;

public class LT025 {
	public static void main ( String[] args ) throws FileNotFoundException {
		Scanner input = new Scanner(new File("c:/Users/ZSong/Desktop/test.txt"));
		ListNode head = null, curr = null; 
		while ( input.hasNextInt() ) {
			ListNode newNode = new ListNode(input.nextInt()); 
			if ( head == null )
				head = newNode;
			else
				curr.next = newNode;
			curr = newNode;
		}
		System.out.println(head.toString());
		head = reverseKGroup(head,2);
		System.out.println(head.toString());
		input.close();
	}
	public static ListNode reverseKGroup(ListNode head, int k) {
		if ( k < 2 || head == null ) return head;
        ListNode start=head, end, prevstart=null;
        while ( start != null ) {
            int i = 0;
            end = start;
            while ( i<k && end != null ) {
                end = end.next;
                i++;
            }
            if ( i == k ) {
                ListNode prev = end, curr=start;
                while ( curr != end ) {
                    ListNode next = curr.next;
                    curr.next = prev;
                    prev = curr;
                    curr = next;
                }
                if ( prevstart == null ) head = prev;
                else prevstart.next = prev;
                prevstart = start;
            }
            start = end;
        }
        return head;
    }
}
