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
public class LT153Test {
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][]{
//			{new int[]{1}, 1},
//			{new int[]{0,1}, 0},
//			{new int[]{1,0}, 0},
//			{new int[]{0,1,2}, 0},
//			{new int[]{2,0,1}, 0},
//			{new int[]{1,2,0}, 0},
//			{new int[]{0,1,2,3,4,5,6,7,8,9}, 0},
//			{new int[]{3,4,5,6,7,8,9,0,1,2}, 0},
//			{new int[]{7,8,9,0,1,2,3,4,5,6}, 0},
			{new int[]{1,1},1},
			{new int[]{4,5,6, 6,7,0,0,1,2},0}
		});
	}
	@Parameter
	public static int[] nums;
	@Parameter(value=1)
	public static int expRes;
	
	private LT153 dummy = new LT153();
	
	@Test
	public void test() {
		int res = dummy.findMin(nums);
		assertEquals(expRes,res);
	}

}
