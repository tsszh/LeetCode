package LT050T100;

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
public class LT61Test {
	@Parameters
	public static Collection<Object[]> initialize() {
		return Arrays.asList(new Object[][]{
			{ new int[] { 1, 2, 3, 4, 5, 6 }, 6, new int[] { 1, 2, 3, 4, 5, 6 } },
			{ new int[] { 1, 2, 3, 4, 5, 6 }, 0, new int[] { 1, 2, 3, 4, 5, 6 } },
			{ new int[] {}, 3, new int[]{} },
			{ new int[] {1}, 3, new int[]{1} },
			{ new int[] { 1, 2, 3, 4, 5, 6 }, 5, new int[] { 2, 3, 4, 5, 6, 1 } },
			{ new int[] { 1, 2, 3, 4, 5, 6 }, 1, new int[] { 6, 1, 2, 3, 4, 5 } },
			{ new int[] { 1, 2, 3, 4, 5, 6 }, 2, new int[] { 5, 6, 1, 2, 3, 4 } },
			{ new int[] { 1, 2, 3, 4, 5, 6 }, 3, new int[] { 4, 5, 6, 1, 2, 3 } },
			{ new int[] { 1, 2, 3, 4, 5, 6 }, 4, new int[] { 3, 4, 5, 6, 1, 2 } },
			{ new int[] { 1, 2, 3, 4, 5, 6, 7 }, 3, new int[] { 5, 6, 7, 1, 2, 3, 4 } }
		});
	}
	@Parameter
	public int[] nums;
	@Parameter(value = 1)
	public int k;
	@Parameter(value = 2)
	public int[] expRes;
	
	private LT61 dummy = new LT61();
	
	@Test
	public void test() {
		ListNode head = ListNodeFactory.creatListNode(nums);
		assertArrayEquals(expRes, ListNodeFactory.toArray(dummy.rotateRight(head, k)));
		
	}
}
