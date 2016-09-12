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
public class P4Test {
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][]{
			{"1.1", "3.2", -1}
		});
	}
	@Parameter
	public String s1;
	@Parameter(value=1)
	public String s2;
	@Parameter(value=2)
	public int expRes;
	
	private P1 dummy = new P1();
	
	@Test
	public void test() {
		assertEquals(1, 2);
	}

}
