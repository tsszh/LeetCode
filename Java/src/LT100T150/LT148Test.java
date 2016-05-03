package LT100T150;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import utilities.ListNode;
import utilities.ListNodeFactory;

@RunWith(Parameterized.class)
public class LT148Test {
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][]{
			{new int[]{}},
			{new int[]{1}},
			{new int[]{3,2,1}},
			{new int[]{1,4,2,4}},
			{new int[]{2,2,1,2,2}},
			{new int[]{6,5,4,3,2,1}}
		});
	}
	@Parameter
	public int[] vals;
	
	private LT148 dummy = new LT148();
	
	@Test
	public void test() {
		ListNode head = ListNodeFactory.creatListNode(vals);
		head = dummy.sortList(head);
		Arrays.sort(vals);
		for ( int i = 0; i < vals.length; i++ ) {
			assertTrue( head != null );
			assertEquals( vals[i], head.val );
			head = head.next;
		}
	}

}
