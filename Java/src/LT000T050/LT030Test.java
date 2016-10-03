package LT000T050;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith( Parameterized.class )
public class LT030Test {
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][]{
			{"barfoothefoobarman", new String[]{"foo", "bar"}, new Integer[]{0,9}},
			{"barfoothefoobar", new String[]{"foo", "bar"}, new Integer[]{0,9}},
			{"barfoothaefoobar", new String[]{"foo", "bar"}, new Integer[]{0,10}},
			{"abarfoothefoobar", new String[]{"foo", "bar"}, new Integer[]{01,10}},
			{"", new String[]{"foo", "bar"}, new Integer[]{}},
			{"abarfoot", new String[]{"foo", "bar"}, new Integer[]{1}},
		});
	}
	@Parameter
	public String s;
	@Parameter(value=1)
	public String[] words;
	@Parameter(value=2)
	public Integer[] expRes;
	
	private LT030 dummy = new LT030();
	
	@Test
	public void test() {
		assertEquals( Arrays.asList(expRes), dummy.findSubstring(s, words) );

	}
}
