package utilities;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ListNodeFactoryTest {

	@Parameters
	public static Collection<Object[]> testData() {
		return Arrays.asList(new Object[][]{
			{0},
			{1},
			{5}
		});
	}
	@Parameter
	public int len;
	
	@Test
	public void test1() {
		ListNode head = ListNodeFactory.createListNode( len );
		for ( int i = 0; i < len; i++ ) {
			assertTrue( head != null );
			assertEquals( head.val, i );
			head = head.next;
		}
		assertTrue( head == null );
	}
	
	@Test
	public void test2() {
		int[] vals = new int[len];
		for ( int i = 0; i < len; i++ ) {
			vals[i] = len - i;
		}
		ListNode head = ListNodeFactory.creatListNode(vals);
		for ( int i = 0; i < len; i++ ) {
			assertTrue( head != null );
			assertEquals( head.val, len-i );
			head = head.next;
		}
	}
}
