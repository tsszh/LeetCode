package LT150T200;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class LT166Test {
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][]{
			{-2147483648, 1, "-2147483648"},
			{-1, -2147483648, "0.0000000004656612873077392578125"},
			{0, -12, "0"},
			{7, -12, "-0.58(3)"},
			{1, 17, "0.(0588235294117647)"},
			{-3, 440, "-0.006(81)"},
			{1, 333, "0.(003)"},
			{-22, 1, "-22"},
			{0, 2, "0"},
			{-31, 11, "-2.(81)"},
			{-21, 7, "-3"},
			{11, 7, "1.(571428)"},
			{-1, 3, "-0.(3)"},
			{1, 3, "0.(3)"},
			{1, 2, "0.5"}
		});
	}
	@Parameter
	public int a;
	@Parameter(value=1)
	public int b;
	@Parameter(value=2)
	public String expRes;
	
	private LT166 dummy = new LT166();
	
	@Test
	public void test() {
		assertEquals(expRes, dummy.fractionToDecimal(a, b));
	}
}
