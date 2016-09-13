package LT150T200;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class LT167Test {
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][]{
			{new int[]{2, 2, 2, 2}, 4, new int[]{1, 4}},
			{new int[]{1,2,3,4,4,9,56,90}, 8, new int[]{4,5}},
			{new int[]{2, 7, 11, 15}, 9, new int[]{1, 2}},
			{new int[]{2, 7, 11, 15}, 18, new int[]{2, 3}},
			{new int[]{2, 7, 11, 15}, 16, null},
			{new int[]{2}, 1, null},
		});
	}
	@Parameter
	public int[] nums;
	@Parameter(value=1)
	public int target;
	@Parameter(value=2)
	public int[] expRes;
	
	private LT167 dummy = new LT167();
	
	@Test
	public void test() {
		int[] res = dummy.twoSum(nums, target);
		if (expRes == null) {
			assertTrue(res == null);
		} else {
			assertEquals(expRes[0], res[0]);
			assertEquals(expRes[1], res[1]);
		}
	}
}
