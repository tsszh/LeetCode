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
public class LT205Test {
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][]{
			{"add", "fee", true},
			{"paper", "title", true},
			{"add", "hle", false},
			{"aaa", "aa", false},
			{"aeed", "bxxc", true},
			{"", "", true}
		});
	}
	@Parameter
	public String s;
	@Parameter(value=1)
	public String t;
	@Parameter(value=2)
	public boolean expRes;
	
	private LT205 dummy = new LT205();
	
	@Test
	public void test() {
		assertEquals( expRes, dummy.isIsomorphic(s, t) );
	}

}