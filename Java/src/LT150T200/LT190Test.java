package LT150T200;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class LT190Test {
	@Parameters
	public static Collection<Object[]> initialize() {
		return Arrays.asList(new Object[][]{
			{1234567890l, 1262512530l},
			{1, 2147483648l},
			{11, 3489660928l},
			{111, 4127195136l},
			{1111, 3927965696l},
			{11111, 3872653312l},
			{123456, 38240256l},
			{1234567, 3781904384l},
			{12345678l, 1921400064l},
			{123456789l, 2830359264l},
			{2147483648l, 1l},
			{2147483649l, 2147483649l},
			{2247483648l, 8892321l},
			{3147483648l, 5462493l},
			{4294967295l, 4294967295l},
			{0, 0}
		});
	}
	@Parameter
	public long n;
	@Parameter(value = 1)
	public long expRes;
	
	private LT190 dummy = new LT190();
	
	@Test
	public void test() {
		assertEquals((int)expRes, dummy.reverseBits((int)n));
	}

}
