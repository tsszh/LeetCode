package Medium3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LT136Test {
	LT136 solution = new LT136();
	@Test
	public void test() {
		int[] nums = new int[]{3,3,2,2,1,4,4};
		assertEquals( solution.xorMethod(nums), 1 );
		assertEquals( solution.hashTableMethod(nums), 1 );
	}

}
