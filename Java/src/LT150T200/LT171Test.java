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
public class LT171Test {
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][]{
			{"AZ", 52},
			{"A", 1},
			{"Z", 26},
			{"AA", 27}
		});
	}
	@Parameter
	public String s;
	@Parameter(value=1)
	public int expRes;
	
	private LT171 dummy = new LT171();
	
	@Test
	public void test() {
		assertEquals(expRes, dummy.titleToNumber(s));
	}
}
