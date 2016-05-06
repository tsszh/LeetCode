package LT150T200;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class LT152Test {
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][]{
//			{new int[]{2,3,-2,4}, 6},
//			{new int[]{2,3,-1,0,2,3,4}, 24},
//			{new int[]{-2}, -2},
//			{new int[]{-3,-4},12},
			{new int[]{2,3,-1,2,-2,-3,4},48}
		});
	}
	@Parameter
	public int[] nums;
	@Parameter(value=1)
	public int expRes;
	
	private LT152 dummy = new LT152();
	
	@Test
	public void test() {
		int res = dummy.maxProduct(nums);
		assertEquals( expRes, res );
	}
	@Test
	public void test2() {
		int res = dummy.maxProduct2(nums);
		assertEquals( expRes, res );
	}

}
