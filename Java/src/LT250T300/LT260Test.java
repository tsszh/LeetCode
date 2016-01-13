package LT250T300;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class LT260Test {
	LT260 sol = new LT260();

	@Test
	public void test() {
		int[] nums = new int[] { 1, 1, 3, 5 };
		int[] res = sol.solve(nums);
		Arrays.sort(res);
		assertEquals(3, res[0]);
		assertEquals(5, res[1]);
	}

}
