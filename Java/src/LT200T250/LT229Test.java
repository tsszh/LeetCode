package LT200T250;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import LT150T200.LT171;

@RunWith(Parameterized.class)
public class LT229Test {
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][]{
			{new int[]{1,2,1,1,1,3,3,4,3,3,3,4,4,4}, new int[]{3}},
			{new int[]{4,2,1,1}, new int[]{1}},
			{new int[]{2,1,2, 1, 1, 3 ,4 ,5}, new int[]{1}},
			{new int[]{1,1}, new int[]{1}},
			{new int[]{2,1,2, 1, 1}, new int[]{1,2}},
			{new int[]{2,2,1, 1, 5}, new int[]{1,2}},
			{new int[]{1,2,1}, new int[]{1}},
			{new int[]{1}, new int[]{1}}
		});
	}
	@Parameter
	public int[] nums;
	@Parameter(value=1)
	public int[] expRes;
	
	private LT229 dummy = new LT229();
	
	@Test
	public void test() {
		List<Integer> tmp = dummy.majorityElement(nums);
		assertEquals(expRes.length, tmp.size());
		if (expRes.length == 1) {
			assertEquals(expRes[0], (int)tmp.get(0));
		} else {
			int[] res = new int[]{tmp.get(0), tmp.get(1)};
			if (res[0] > res[1]) {
				res[0] = tmp.get(1);
				res[1] = tmp.get(0);
			}
			for (int i = 0; i < expRes.length; i++) {
				assertEquals(expRes[i], res[i]);
			}
		}
	}
}