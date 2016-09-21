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
public class LT179Test {
	@Parameters
	public static Collection<Object[]> initialize() {
		return Arrays.asList(new Object[][]{
			{new int[]{0,0}, "0"},
			{new int[]{3, 30, 34, 5, 9}, "9534330"},
			{new int[]{}, "0"},
			{new int[]{1,2}, "21"}
		});
	}
	@Parameter
	public int[] nums;
	@Parameter(value = 1)
	public String expRes;
	
	private LT179 dummy = new LT179();
	@Test
	public void test() {
		assertEquals(expRes, dummy.largestNumber(nums));
	}

}
