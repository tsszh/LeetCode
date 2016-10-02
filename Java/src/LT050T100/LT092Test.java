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
public class LT092Test {
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][]{
			{new int[]{1,2,3,4,5}, 2, 4, new int[]{1,4,3,2,5}},
			{new int[]{1,2,3,4,5}, 1, 5, new int[]{5,4,3,2,1}},
			{new int[]{1,2,3,4,5}, 1, 2, new int[]{2,1,3,4,5}},
			{new int[]{1,2,3,4,5}, 2, 2, new int[]{1,2,3,4,5}},
			{new int[]{1}, 1, 1, new int[]{1}},
		});
	}
	@Parameter
	public int[] input;
	@Parameter(value=1)
	public int m;
	@Parameter(value=2)
	public int n;
	@Parameter(value=3)
	public int[] expRes;
	
	private LT092 dummy = new LT092();
	
	@Test
	public void test() {
		ListNode head = ListNodeFactory.creatListNode(input);
		assertArrayEquals(expRes, ListNodeFactory.toArray(dummy.reverseBetween(head, m, n)));
	}
}