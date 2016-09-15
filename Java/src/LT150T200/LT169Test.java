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
public class LT169Test {
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][]{
			{new int[]{2,1,2, 1, 1}, 1},
			{new int[]{2,2,1, 1, 1}, 1},
			{new int[]{1,2,1}, 1},
			{new int[]{1}, 1}
		});
	}
	@Parameter
	public int[] nums;
	@Parameter(value=1)
	public int expRes;
	
	private LT169 dummy = new LT169();
	
	@Test
	public void test() {
		assertEquals(expRes, dummy.majorityElement(nums));
	}
}
