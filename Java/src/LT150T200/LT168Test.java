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
public class LT168Test {
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][]{
			{52, "AZ"},
			{1, "A"},
			{26, "Z"},
			{27, "AA"},
		});
	}
	@Parameter
	public int num;
	@Parameter(value=1)
	public String expRes;
	
	private LT168 dummy = new LT168();
	
	@Test
	public void test() {
		assertEquals(expRes, dummy.convertToTitle(num));
	}
}
