package LT350T400;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class LT389Test {

	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][]{
			{"abcd", "abcde", 'e'},
			{"aaa", "aaaa", 'a'}
		});
	}
	@Parameter
	public String s;
	@Parameter(value=1)
	public String t;
	@Parameter(value=2)
	public char c;
	
	private LT389 dummy = new LT389();
	
	@Test
	public void test() {
		char r = dummy.findTheDifference(s, t);
		assertEquals( r, c );
	}

}
