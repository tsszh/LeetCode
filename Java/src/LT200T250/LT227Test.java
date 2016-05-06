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
public class LT227Test {
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][]{
			{"1+2*3",7},
			{"1+2*5/3+6/4*2", 6},
			{"1-5/2", -1},
			{"1+2*10/3",7}
		});
	}
	@Parameter
	public String s;
	@Parameter(value=1)
	public int expRes;
	
	private LT227 dummy = new LT227();
	
	@Test
	public void test() {
		int res = dummy.calculate(s);
		assertEquals( expRes, res );
	}
	@Test
	public void test2() {
		int res = dummy.calculate2(s);
		assertEquals( expRes, res );
	}
}
