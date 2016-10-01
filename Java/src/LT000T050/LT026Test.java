package LT000T050;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;


@RunWith( Parameterized.class )
public class LT026Test {
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][]{
			{new int[]{}, new int[]{}},
			{new int[]{1}, new int[]{1}},
			{new int[]{1,1}, new int[]{1}},
			{new int[]{1,2,3}, new int[]{1,2,3}},
			{new int[]{1,2,2,3,3}, new int[]{1,2,3}},
			{new int[]{1,1,1,2,2,3,3}, new int[]{1,2,3}}
		});
	}
	@Parameter
	public int[] originalNums;
	@Parameter(value=1)
	public int[] expRes;
	
	private LT026 dummy = new LT026();
	
	@Test
	public void test() {
		int[] nums = Arrays.copyOf(originalNums, originalNums.length);
		assertEquals( expRes.length, dummy.removeDuplicates(nums) );
		nums = Arrays.copyOfRange(nums, 0, expRes.length);
		Arrays.sort(expRes);
		Arrays.sort(nums);
		assertArrayEquals(expRes, nums);
	}
}