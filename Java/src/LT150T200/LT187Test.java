package LT150T200;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class LT187Test {
	@Parameters
	public static Collection<Object[]> initialize() {
		return Arrays.asList(new Object[][]{
			{"AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT", new String[]{
				"AAAAACCCCC", "CCCCCAAAAA"
			}}
		});
	}
	@Parameter
	public String s;
	@Parameter(value = 1)
	public String[] expRes;
	
	private LT187 dummy = new LT187();
	
	@Test
	public void test() {
		Set<String> expSet = new HashSet<>(Arrays.asList(expRes));
		List<String> res = dummy.findRepeatedDnaSequences(s);
		Set<String> set = new HashSet<>(res);
		assertEquals(expSet, set);
		
	}

}
