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
public class LT27Test {
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][]{
			{new int[]{3,2,2,3}, 3, new int[]{2,2}},
			{new int[]{3,2,2,3}, 2, new int[]{3,3}},
			{new int[]{1}, 2, new int[]{1}},
			{new int[]{1}, 1, new int[]{}},
			{new int[]{}, 1, new int[]{}},
			{new int[]{3,3,1,1,3,3}, 3, new int[]{1,1}},
		});
	}
	@Parameter
	public int[] originalNums;
	@Parameter(value=1)
	public int val;
	@Parameter(value=2)
	public int[] expRes;
	
	private LT27 dummy = new LT27();
	
	@Test
	public void test() {
		int[] nums = Arrays.copyOf(originalNums, originalNums.length);
		assertEquals( expRes.length, dummy.removeElement(nums, val) );
		nums = Arrays.copyOfRange(nums, 0, expRes.length);
		Arrays.sort(expRes);
		Arrays.sort(nums);
		assertArrayEquals(expRes, nums);
	}
	@Test
	public void test2() {
		int[] nums = Arrays.copyOf(originalNums, originalNums.length);
		assertEquals( expRes.length, dummy.removeElement2(nums, val) );
		nums = Arrays.copyOfRange(nums, 0, expRes.length);
		Arrays.sort(expRes);
		Arrays.sort(nums);
		assertArrayEquals(expRes, nums);
	}

}