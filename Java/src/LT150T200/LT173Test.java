package LT150T200;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import utilities.TreeFactory;
import utilities.TreeNode;

@RunWith(Parameterized.class)
public class LT173Test {
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][]{
			{"{5,2,8,1,4,6,9,#,#,3,#,#,7}", new int[]{1,2,3,4,5,6,7,8,9}},
			{"{1}", new int[]{1}},
			{"{2,1,5,#,#,3,#,#,4}", new int[]{1,2,3,4,5}},
			{"{}", new int[]{}},
			{"{1,#,2}", new int[]{1,2}},
			{"{3,2,#,1}", new int[]{1,2,3}},
			{"{1,#,2,#,3}", new int[]{1,2,3}}
		});
	}
	@Parameter
	public String input;
	@Parameter(value=1)
	public int[] expRes;
	
	@Test
	public void test() {
		TreeNode root = TreeFactory.deserialize( input );
		LT173 it = new LT173(root);
		for (int x : expRes) {
			assertTrue(it.hasNext());
			assertEquals(x, it.next());
		}
		assertTrue(it.hasNext() == false);
	}
}
