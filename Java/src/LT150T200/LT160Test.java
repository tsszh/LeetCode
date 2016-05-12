package LT150T200;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import utilities.ListNode;
import utilities.ListNodeFactory;

@RunWith(Parameterized.class)
public class LT160Test {
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][]{
			{ 2, 3, 2 },
			{ 0, 3, 2 },
			{ 3, 3, 0 },
			{ 3, 0, 2 },
			{ 0, 0, 0 }
		});
	}
	@Parameter
	public int lenA;
	@Parameter(value=1)
	public int lenB;
	@Parameter(value=2)
	public int lenC;
	
	private LT160 dummy = new LT160();
	
	private ListNode headA, headB;
	
	@Before
	public void initialize(){
		headA = ListNodeFactory.createListNode(lenA);
		headB = ListNodeFactory.createListNode(lenB);
	}
	@Test
	public void test() {
		ListNode headC = ListNodeFactory.createListNode(lenC);
		ListNode expRes = new ListNode(0);
		expRes.next = headC;
		ListNode temp = headA;
		if ( temp == null ) {
			headA = expRes;
		} else {
			while ( temp.next != null ) temp = temp.next;
			temp.next = expRes;
		}
		
		temp = headB;
		if ( temp == null ) {
			headB = expRes;
		} else {
			while ( temp.next != null ) temp = temp.next;
			temp.next = expRes;
		}
		
		ListNode res = dummy.getIntersectionNode(headA, headB);
		assertEquals(expRes, res);
	}
	
	@Test
	public void testNull() {
		assertTrue( dummy.getIntersectionNode(headA, headB) == null );
	}
}
