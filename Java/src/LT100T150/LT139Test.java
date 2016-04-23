package LT100T150;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class LT139Test {
	@Parameters
	public static Collection<Object[]> testData() {
		return Arrays.asList(new Object[][]{
			{"leetcode", true},
			{"leetcod", false},
			{"leet",true},
			{"",true}
		});
	}
	
	@Parameter
	public String key;
	@Parameter(value=1)
	public boolean expRes;
	
	private Set<String> wordDict = new HashSet<>(Arrays.asList(new String[]{
			"leet","code"
	}));
	
	@Test
	public void test() {
		assertEquals(expRes,new LT139().wordBreak(key, wordDict));
	}
	@Test
	public void test2() {
		assertEquals(expRes,new LT139().wordBreakQuick(key, wordDict));
	}
}
