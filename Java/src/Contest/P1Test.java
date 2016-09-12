package Contest;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class P1Test {
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][]{
			{new int[]{4,3,2,6}, 26}
		});
	}
	@Parameter
	public int[] A;
	@Parameter(value=1)
	public int expRes;
	
	private P1 dummy = new P1();
	
	@Test
	public void test() {
		assertEquals(expRes, dummy.maxRotateFunction(A));
	}

}
