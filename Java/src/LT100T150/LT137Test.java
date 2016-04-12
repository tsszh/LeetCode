package LT100T150;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LT137Test {
	LT137 solution = new LT137();

	@Test
	public void test1() {
		int[] nums = new int[] { 211 };
		assertEquals(211, solution.bitCountMethod(nums));
	}

	@Test
	public void test2() {
		int[] nums = new int[] { 211, 211 };
		assertEquals(211, solution.bitCountMethod(nums));
	}

	@Test
	public void test3() {
		int[] nums = new int[] { 211, 123, 211, 211 };
		assertEquals(123, solution.bitCountMethod(nums));
	}
}
