package LT000T050;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class LT005Test {
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][]{
			{"abb", "bb"},
			{"aacecaaa", "aacecaa"},
			{"abbcd", "bb"},
			{"abbbcd", "bbb"},
			{"a", "a"},
			{"aa", "aa"},
			{"", ""},
			{"abcabacada", "cabac"}
		});
	}
	@Parameter
	public String s;
	@Parameter(value=1)
	public String expRes;
	
	private LT005 dummy = new LT005();
	
	@Test
	public void test() {
		assertEquals(expRes, dummy.longestPalindrome(s));
	}

}