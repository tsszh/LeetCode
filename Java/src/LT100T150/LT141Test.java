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
public class LT141Test {
	
	@Parameters
	public static Collection<Object[]> testData() {
		return Arrays.asList(new Object[][]{
			{5, false, 0},
			{6, true, 2},
			{5, true, 5},
			{5, true, 1},
			{1, true, 1},
			{1, false, 1},
			{0, false, 1},
			{1000000, true, 400},
			{1000000, false, 0}
		});
	}
	@Parameter
	public int len;
	@Parameter( value = 1 )
	public boolean expRes;
	@Parameter( value= 2 )
	public int jointPoint;
	
	private LT141 dummy = new LT141();
	private ListNode head;
	
	@Before
	public void initialize() {
		if ( expRes ) head = createCycleLinkedList();
		else head = ListNodeFactory.createListNode(len);
	}
	@Test
	public void test() {
		assertEquals( dummy.hasCycle(head), expRes );
	}
	
	@Test
	public void test2() {
		assertEquals( dummy.hasCycle2(head), expRes );
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
