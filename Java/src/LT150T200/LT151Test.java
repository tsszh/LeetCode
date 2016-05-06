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
public class LT151Test {
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][]{
			{"the sky is blue","blue is sky the"},
			{"",""},
			{" ", ""},
			{" ab ", "ab"},
			{"  the   sky   is   blue  ","blue is sky the"},
		});
	}
	@Parameter
	public String s;
	@Parameter(value=1)
	public String expRes;
	
	private LT151 dummy = new LT151();
	
	@Test
	public void test() {
		String res = dummy.reverseWords(s);
		assertEquals( expRes, res );
	}

}
