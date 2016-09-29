package LT000T050;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith( Parameterized.class )
public class LT7Test {
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][]{
			{0, 0},
			{1, 1},
			{12, 21},
			{123, 321},
			{1234, 4321},
			{12345, 54321},
			{123456, 654321},
			{1234567, 7654321},
			{123456789, 987654321},
			{1234567890, 987654321},
			{2147483647, 0},
			{-1, -1},
			{-12, -21},
			{-123, -321},
			{-1234, -4321},
			{-12345, -54321},
			{-123456, -654321},
			{-1234567, -7654321},
			{-123456789, -987654321},
			{-1234567890, -987654321},
			{-2147483647, 0},
			{-2147483648, 0}
		});
	}
	@Parameter
	public int n;
	@Parameter(value=1)
	public int expRes;
	
	private LT7 dummy = new LT7();
	
	@Test
	public void test() {
		assertEquals( expRes, dummy.reverse(n) );
	}

}
