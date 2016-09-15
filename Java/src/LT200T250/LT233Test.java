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
public class LT233Test {
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][]{
			{13, 6},
			{10, 2},
			{2, 1},
			{1, 1},
			{0, 0},
			{100, 21}
		});
	}
	@Parameter
	public int n;
	@Parameter(value=1)
	public int expRes;
	
	private LT233 dummy = new LT233();
	
	@Test
	public void test() {
		assertEquals(expRes, dummy.countDigitOne(n));
	}
}
