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
public class LT165Test {
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][]{
			{"1.1", "3.2", -1},
			{"1.1", "0.2", 1},
			{"1.1", "1.2", -1},
			{"1.1", "1.0", 1},
			{"1.1", "1.1", 0},
			{"1.", "1.1", -1},
			{"1", "1.1", -1},
			{"", "1.1", -1},
			{"1", ".1", 1},
			{"1.1.1", "1.1", 1},
			{"1.0.1", "1..1", 0},
			{"1.0.1", "1..", 1},
			{"1.0.1", "1.", 1},
		});
	}
	@Parameter
	public String s1;
	@Parameter(value=1)
	public String s2;
	@Parameter(value=2)
	public int expRes;
	
	private LT165 dummy = new LT165();
	
	@Test
	public void test() {
		assertEquals(expRes, dummy.compareVersion(s1, s2));
	}

}

