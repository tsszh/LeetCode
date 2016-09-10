package LT150T200;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class LT162Test {
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][]{
			{ new int[] {1}, new int[]{0} },
			{ new int[] {1, 2}, new int[]{1} },
			{ new int[] {2, 1}, new int[]{0} },
			{ new int[] {1, 2, 3}, new int[]{2} },
			{ new int[] {3, 2, 1}, new int[]{0} },
			{ new int[] {3, 1, 2}, new int[]{0, 2} },
			{ new int[] {4, 3, 1, 2, 5, 0}, new int[]{0, 4} },
		});
	}
	@Parameter
	public int[] nums;
	@Parameter(value=1)
	public int[] expRes;
	
	private LT162 dummy = new LT162();
	
	@Test
	public void test() {
		int res = dummy.findPeakElement(nums);
		boolean flag = false;
		for ( int n : expRes ) {
			if ( res == n ) flag = true;
		}
		assertTrue(flag);
	}
}
