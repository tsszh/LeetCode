package LT150T200;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class LT189Test {
	@Parameters
	public static Collection<Object[]> initialize() {
		return Arrays.asList(new Object[][] {
			{ new int[] { 1, 2, 3, 4, 5, 6 }, 1, new int[] { 6, 1, 2, 3, 4, 5 } },
			{ new int[] { 1, 2, 3, 4, 5, 6 }, 2, new int[] { 5, 6, 1, 2, 3, 4 } },
			{ new int[] { 1, 2, 3, 4, 5, 6 }, 3, new int[] { 4, 5, 6, 1, 2, 3 } },
			{ new int[] { 1, 2, 3, 4, 5, 6 }, 4, new int[] { 3, 4, 5, 6, 1, 2 } },
			{ new int[] { 1, 2, 3, 4, 5, 6 }, 5, new int[] { 2, 3, 4, 5, 6, 1 } },
			{ new int[] { 1, 2, 3, 4, 5, 6 }, 6, new int[] { 1, 2, 3, 4, 5, 6 } },
			{ new int[] { 1, 2, 3, 4, 5, 6 }, 0, new int[] { 1, 2, 3, 4, 5, 6 } },
			{ new int[] { 1, 2, 3, 4, 5, 6, 7 }, 3, new int[] { 5, 6, 7, 1, 2, 3, 4 } },
			{ new int[] {}, 3, new int[]{} },
			{ new int[] {1}, 3, new int[]{1} }
		});
	}

	@Parameter
	public int[] nums;
	@Parameter(value = 1)
	public int k;
	@Parameter(value = 2)
	public int[] expRes;

	private LT189 dummy = new LT189();

	@Test
	public void test() {
		dummy.rotate(nums, k);
		assertArrayEquals(expRes, nums);
	}

}
