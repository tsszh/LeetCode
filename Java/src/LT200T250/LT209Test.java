package LT200T250;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class LT209Test {
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][]{
			{new int[]{2,3,1,2,4,3}, 7, 2},
			{new int[]{2,3,1,2,4,3}, 4, 1},
			{new int[]{1,2,3}, 6, 3},
			{new int[]{1,2,3}, 5, 2},
			{new int[]{1,2,3}, 7, 0},
			{new int[]{1,2,3}, 3, 1},
			{new int[]{}, 3, 0},
			{new int[]{1}, 3, 0},
			{new int[]{1}, 1, 1}
		});
	}
	@Parameter
	public int[] nums;
	@Parameter(value=1)
	public int s;
	@Parameter(value=2)
	public int expRes;
	
	private LT209 dummy = new LT209();
	
	@Test
	public void test() {
		assertEquals(expRes, dummy.minSubArrayLen(s, nums));
	}

}