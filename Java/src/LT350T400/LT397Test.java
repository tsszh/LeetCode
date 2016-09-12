package LT350T400;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class LT397Test {
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][]{
			{1, 0},
			{2, 1},
			{3, 2},
			{4, 2},
			{5, 3},
			{6, 3},
			{7, 4},
			{8, 3},
			{9, 4},
			{10, 4},
			{11, 5},
			{12, 4},
			{13, 5},
			{14, 5},
			{15, 5},
			{2147483647, 32}
		});
	}
	@Parameter
	public int n;
	@Parameter(value=1)
	public int expRes;
	
	private LT397 dummy = new LT397();
	
	@Test
	public void test() {
		assertEquals(expRes, dummy.integerReplacement(n));
	}
	@Test
	public void test2() {
		assertEquals(expRes, dummy.integerReplacementQuick(n));
	}

}