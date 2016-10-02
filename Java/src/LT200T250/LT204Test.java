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
public class LT204Test {
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][]{
			{2, 0},
			{3, 1},
			{4, 2},
			{5, 2},
			{6, 3},
			{18, 7},
			{20, 8},
			{24, 9},
			{32, 11},
			{45, 14},
			{47, 14},
			{48, 15},
			{60, 17},
			{70, 19},
			{80, 22},
			{90, 24},
			{100, 25},
			{1000, 168}
		});
	}
	@Parameter
	public int n;
	@Parameter(value=1)
	public int expRes;
	
	private LT204 dummy = new LT204();
	
	@Test
	public void test() {
		assertEquals( expRes, dummy.countPrimes(n) );
	}

}
