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
public class LT143Test {
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][]{
			{0},
			{1},
			{2},
			{3},
			{4},
			{5},
			{6},
		});
	}
	@Parameter
	public int len;
	
	private ListNode head;
	private LT143 dummy = new LT143();
	
	@Before
	public void intitialize(){
		head = ListNodeFactory.createListNode(len);
	}
	@Test
	public void test() {
		dummy.reorderList(head);
		int s = 0, e = len-1, count = 0;
		while ( head != null ) {
			if ( count%2 == 0 ) {
				assertEquals( s++, head.val );
			} else {
				assertEquals( e--, head.val );
			}
			head = head.next;
			count++;
		}
		assertEquals(len,count);
	}
}
