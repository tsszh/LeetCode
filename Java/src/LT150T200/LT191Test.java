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
public class LT191Test {
	@Parameters
	public static Collection<Object[]> initialize() {
		return Arrays.asList(new Object[][]{
			{3, 2},
			{-1, 32},
			{Integer.MIN_VALUE, 1},
			{Integer.MAX_VALUE, 31}
		});
	}
	@Parameter
	public int n;
	@Parameter(value = 1)
	public int expRes;
	
	private LT191 dummy = new LT191();
	
	@Test
	public void test() {
		assertEquals(expRes, dummy.hammingWeight(n));
	}

}
