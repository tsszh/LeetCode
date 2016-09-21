package LT300T350;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class LT309Test {
	@Parameters
	public static Collection<Object[]> initialize() {
		return Arrays.asList(new Object[][]{
			{new int[]{1}, 0},
			{new int[]{1,2,3,0,2}, 3},
			{new int[]{1,3,3,6}, 5},
			{new int[]{7, 1, 5, 3, 6, 4}, 5},
			{new int[]{1,3,6}, 5},
			{new int[]{}, 0},
			{new int[]{7, 6, 4, 3, 1}, 0}
		});
	}
	@Parameter
	public int[] prices;
	@Parameter(value = 1)
	public int expRes;
	
	private LT309 dummy = new LT309();
	
	@Test
	public void test() {
		assertEquals(expRes, dummy.maxProfit(prices));
		
	}

}
