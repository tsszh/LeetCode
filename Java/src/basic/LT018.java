package basic;

import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

public class LT018 {
	public static void main ( String[] args ) 
			throws FileNotFoundException {
		Scanner input = new Scanner(new File("c:/Users/ZSong/Desktop/test.txt"));
		ListNode head, tail;
		head = new ListNode(input.nextInt());
		tail = head;
		while ( input.hasNextInt() ) {
			tail.next = new ListNode(input.nextInt());
			tail = tail.next;
		}
		Scanner in = new Scanner(System.in);
		System.out.println(head.toString());
		while ( in.hasNextInt() ) {
			System.out.println(head.toString());
			head = removeNthFromEnd(head,in.nextInt());
			System.out.println(head.toString());
		}
		in.close();
		input.close();
	}
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode fast=head;
		while ( n-->0 ) {
			fast = fast.next;
		}
		ListNode prev = null, slow=head;
		while ( fast != null ) {
			fast = fast.next;
			prev = slow;
			slow = slow.next;
		}
		if ( prev == null ) return head.next;
		else {
			prev.next = slow.next;
			return head;
		}
    }

}

