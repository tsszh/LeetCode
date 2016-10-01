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
public class LT201Test {
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][]{
			{0,7,0},
			{5,7,4},
			{3,7,0},
			{13,15,12}
		});
	}
	@Parameter
	public int m;
	@Parameter(value=1)
	public int n;
	@Parameter(value=2)
	public int expRes;
	
	private LT201 dummy = new LT201();
	
	@Test
	public void test() {
		int res = dummy.rangeBitwiseAnd(m, n);
		assertEquals( expRes, res );
	}

}
