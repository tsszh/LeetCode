package LT100T150;

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
public class LT142Test {
	@Parameters
	public static Collection<Object[]> testData() {
		return Arrays.asList(new Object[][]{
			{5, false, 0},
			{6, true, 3},
			{1, true, 1},
			{0, false, 0},
			{1000000, true, 400},
			{1000000, false, 0}
		});
	}
	@Parameter
	public int len;
	@Parameter( value = 1 )
	public boolean hasCycle;
	@Parameter( value= 2 )
	public int jointPoint; // jointPoin-1 is the val of joint node
	
	private LT142 dummy = new LT142();
	private ListNode head;
	
	@Before
	public void initialize() {
		if ( hasCycle ) head = createCycleLinkedList();
		else head = ListNodeFactory.createListNode(len);
	}
	@Test
	public void test() {
		if ( hasCycle )
			assertEquals( dummy.detectCycle(head).val, jointPoint-1 );
		else
			assertTrue( dummy.detectCycle(head) == null );
	}
	
	private ListNode createCycleLinkedList() {
		assertTrue( jointPoint <= len && jointPoint > 0 );
		ListNode head = ListNodeFactory.createListNode(len);
		ListNode joint=null, tail = head;
		for ( int i = 1; i <= len; i++ ) {
			if ( i == jointPoint ) joint = tail;
			if ( i != len ) tail = tail.next;
		}
		tail.next = joint;
		return head;
	}
}
