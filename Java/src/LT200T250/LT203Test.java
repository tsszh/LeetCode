package LT200T250;

import static org.junit.Assert.assertArrayEquals;

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
public class LT203Test {
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][]{
			{new int[]{1}, 1, new int[]{}},
			{new int[]{1}, 0, new int[]{1}},
			{new int[]{1,2,3,4,2,3}, 2, new int[]{1,3,4,3}},
			{new int[]{1,2,3,4,2,3}, 0, new int[]{1,2,3,4,2,3}},
			{new int[]{1,2,3,4,2,3}, 1, new int[]{2,3,4,2,3}},
			{new int[]{1,2,3,4,2,3}, 3, new int[]{1,2,4,2}},
			{new int[]{1,2,3,4,2,3}, 4, new int[]{1,2,3,2,3}},
			{new int[]{}, 1, new int[]{}}
		});
	}
	@Parameter
	public int[] input;
	@Parameter(value=1)
	public int val;
	@Parameter(value=2)
	public int[] expRes;
	
	private LT203 dummy = new LT203();
	
	@Test
	public void test() {
		ListNode head = ListNodeFactory.creatListNode(input);
		assertArrayEquals( expRes, ListNodeFactory.toArray(dummy.removeElements(head, val)) );
	}

}