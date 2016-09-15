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
public class LT172Test {
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][]{
			{1808548329, 452137076},
			{125, 31},
			{101, 24},
			{1, 0},
			{25, 6}
		});
	}
	@Parameter
	public int n;
	@Parameter(value=1)
	public int expRes;
	
	private LT172 dummy = new LT172();
	
	@Test
	public void test() {
		assertEquals(expRes, dummy.trailingZeroes(n));
	}
}