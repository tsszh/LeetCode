package utilities;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TreeFactoryTest {
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList( new Object[][]{
			{"{1,2,3,#,#,4,#,#,5}"},
			{"{}"},
			{"{1}"},
			{"{1,2,#,3}"}
		} );
	}
	@Parameter
	public String input;
	
	@Test
	public void test() {
		TreeNode root = TreeFactory.deserialize( input );
		TreeFactory.verticalTreePrint(root);
		String res = TreeFactory.serialize(root);
		System.out.println( res );
		assertEquals( input, res );
		System.out.println("____________________________________________________________");
	}

}
