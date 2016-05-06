package LT150T200;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith( Parameterized.class )
public class LT150Test {
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][]{
			{new String[]{"2", "1", "+", "3", "*"}, 9},
			{new String[]{"1"}, 1},
			{new String[]{"4", "13", "5", "/", "+"}, 6},
			{new String[]{"2", "3", "-", "6", "*"}, -6}
		});
	}
	@Parameter
	public String[] tokens;
	@Parameter(value=1)
	public int expRes;
	
	private LT150 dummy = new LT150();
	
	@Test
	public void test() {
		int res = dummy.evalRPN(tokens);
		assertEquals( expRes, res );
	}

}
