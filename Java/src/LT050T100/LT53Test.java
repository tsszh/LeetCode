package LT050T100;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class LT53Test {
	@Parameters
	public static Collection<Object[]> initialize() {
		return Arrays.asList(new Object[][]{
			{new int[]{8,-19,5,-4,20}, 21},
			{new int[]{-1,-2,0,-3}, 0},
			{new int[]{-1}, -1},
			{new int[]{1,2,3}, 6},
			{new int[]{-2,1,-3,4,-1,2,1,-5,4}, 6}
		});
	}
	@Parameter
	public int[] nums;
	@Parameter(value = 1)
	public int expRes;
	
	private LT53 dummy = new LT53();
	
	@Test
	public void test() {
		assertEquals(expRes, dummy.maxSubArray(nums));
		
	}
	
	@Test
	public void test2() {
		assertEquals(expRes, dummy.maxSubArray2(nums));
		
	}
}
