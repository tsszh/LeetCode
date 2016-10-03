package LT050T100;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class LT076Test {
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][]{
			{"ADOBECODEBANC", "ABC", "BANC"},
			{"ABBCD", "ABBD", "ABBCD"},
			{"aaa", "bbbb", ""},
			{"ABABCFBD", "ABBD", "ABCFBD"}
		});
	}
	@Parameter
	public String s;
	@Parameter(value=1)
	public String t;
	@Parameter(value=2)
	public String expRes;
	
	private LT076 dummy = new LT076();
	
	@Test
	public void test() {
		assertEquals(expRes, dummy.minWindow(s, t));
	}
}