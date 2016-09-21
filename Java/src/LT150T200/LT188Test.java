package LT150T200;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class LT188Test {
	@Parameters
	public static Collection<Object[]> initialize() {
		return Arrays.asList(new Object[][]{
			{new int[]{3,3,5,0,0,3,1,4}, 2, 6},
			{new int[]{1,3}, 0, 0},
			{new int[]{1,3,3,6}, 4, 5},
			{new int[]{7, 1, 5, 3, 6, 4}, 2, 7},
			{new int[]{7, 1, 5, 3, 6, 4}, 1, 5},
			{new int[]{1,3,6}, 2, 5},
			{new int[]{}, 1, 0},
			{new int[]{7, 6, 4, 3, 1}, 2, 0}
		});
	}
	@Parameter
	public int[] prices;
	@Parameter(value = 1)
	public int k;
	@Parameter(value = 2)
	public int expRes;
	
	private LT188 dummy = new LT188();
	
	@Test
	public void test() {
		assertEquals(expRes, dummy.maxProfit(k, prices));
		
	}

}
