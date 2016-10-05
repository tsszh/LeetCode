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
public class LT214Test {
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][]{
			{"aacecaaa", "aaacecaaa"},
			{"abcd", "dcbabcd"},
			{"a", "a"},
			{"aa", "aa"},
			{"", ""}
		});
	}
	@Parameter
	public String s;
	@Parameter(value=1)
	public String expRes;
	
	private LT214 dummy = new LT214();
	
	@Test
	public void test() {
		assertEquals(expRes, dummy.shortestPalindrome(s));
	}

}
