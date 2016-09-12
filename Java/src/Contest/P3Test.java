package Contest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class P3Test {
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][]{
			{new int[]{1,2,3,3,3}, 1, new int[]{0}}
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
		P3 obj = new P3(nums);
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < expRes.length; i++ ) {
			set.add(expRes[i]);
		}
		int res = obj.pick(target);
		System.out.println(nums + " " + target + " " + res);
		assertTrue(set.contains(res));
	}

}
