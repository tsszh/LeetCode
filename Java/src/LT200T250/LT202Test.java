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
public class LT202Test {
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][]{
			{19, true},
			{82, true},
			{100, true},
			{1, true},
			{2, false}
			
		});
	}
	@Parameter
	public int n;
	@Parameter(value=1)
	public boolean expRes;
	
	private LT202 dummy = new LT202();
	
	@Test
	public void test() {
		assertEquals( expRes, dummy.isHappy(n) );
	}
	@Test
	public void test2() {
		assertEquals( expRes, dummy.isHappy2(n) );
	}

}
