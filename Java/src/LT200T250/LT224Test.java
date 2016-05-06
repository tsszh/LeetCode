package LT200T250;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class LT224Test {
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][]{
			{"1+2*5/3+6/4*2", 6},
			{"1+(2+31)-4",30},
			{"6+ ((2+(3- 4 )+5))",12},
			{"1 + 1", 2},
			{" 2-1 + 2 ",3},
			{"(1+(4+5+2)-3)+(6+8)",23},
			{"2-(3+4)",-5}
		});
	}
	@Parameter
	public String s;
	@Parameter(value=1)
	public int expRes;
	
	private LT224 dummy = new LT224();
	
	@Test
	public void test() {
		int res = dummy.calculate(s);
		assertEquals( expRes, res );
	}

}
