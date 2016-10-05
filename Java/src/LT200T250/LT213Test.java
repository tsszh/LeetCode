package LT200T250;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class LT213Test {
	@Parameters
	public static Collection<Object[]> initialize() {
		return Arrays.asList(new Object[][]{
			{new int[]{1,2,3,4,5}, 8},
			{new int[]{1,2,3,4,5,6}, 12},
			{new int[]{2,1}, 2},
			{new int[]{1,2}, 2},
			{new int[]{3}, 3},
			{new int[]{1,5,3}, 5},
			{new int[]{1,2,3}, 3},
		});
	}
	@Parameter
	public int[] nums;
	@Parameter(value = 1)
	public int expRes;
	
	private LT213 dummy = new LT213();
	
	@Test
	public void test() {
		assertEquals(expRes, dummy.rob(nums));
	}

}