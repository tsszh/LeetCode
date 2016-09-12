package LT350T400;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class LT398Test {
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][]{
			{new int[]{1,2,3,3,3}, 3, new int[]{2,3,4}},
			{new int[]{3,2, 1, 3,3,3}, 3, new int[]{0, 3, 4, 5}}
		});
	}
	@Parameter
	public int[] nums;
	@Parameter(value=1)
	public int target;
	@Parameter(value=2)
	public int[] expRes;
	
	@Test
	public void test() {
		LT398 dummy = new LT398(nums);
		int n = 10000;
		Map<Integer, Integer> res = new HashMap<>(expRes.length);
		for (int i = 0; i < expRes.length; i++) {
			res.put(expRes[i], 0);
		}
		while (n-- > 0) {
			int pick = dummy.pick(target);
			if (res.containsKey(pick)) {
				res.replace(pick, res.get(pick) + 1);
			} else {
				fail();
			}
		}
		
		int min=Integer.MAX_VALUE, max=Integer.MIN_VALUE;
		for (int c : res.values()) {
			if (c < min) min = c;
			if (c > max) max = c;
		}
		assertTrue(max - min < 500);
	}

}
