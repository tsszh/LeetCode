package LT200T250;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class LT231Test {
	@Parameters
	public static Collection<Object[]> initialize() {
		return Arrays.asList(new Object[][]{
			{2, true},
			{1073741824, true},
			{-1, false},
			{0, false},
			{3, false},
			{111, false},
			{Integer.MIN_VALUE, false},
			{Integer.MAX_VALUE, false}
		});
	}
	@Parameter
	public int n;
	@Parameter(value = 1)
	public boolean expRes;
	
	private LT231 dummy = new LT231();
	
	@Test
	public void test() {
		assertEquals(expRes, dummy.isPowerOfTwo(n));
	}

}
