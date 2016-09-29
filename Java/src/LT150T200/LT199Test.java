package LT150T200;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import utilities.TreeFactory;
import utilities.TreeNode;

@RunWith(Parameterized.class)
public class LT199Test {
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][]{
			{"{5,2,8,1,4,6,9,#,#,3,#,#,7}", new int[]{5,8,9,7}},
			{"{1}", new int[]{1}},
			{"{2,1,5,#,#,3,#,#,4}", new int[]{2,5,3,4}},
			{"{}", new int[]{}},
			{"{1,#,2}", new int[]{1,2}},
			{"{3,2,#,1}", new int[]{3,2,1}},
			{"{1,#,2,#,3}", new int[]{1,2,3}}
		});
	}
	@Parameter
	public String input;
	@Parameter(value=1)
	public int[] expRes;
	
	LT199 dummy = new LT199();
	
	@Test
	public void test() {
		TreeNode root = TreeFactory.deserialize( input );
		List<Integer> res = dummy.rightSideView(root);
		assertEquals(expRes.length, res.size());
		for (int i = 0; i < expRes.length; i++) {
			assertEquals(expRes[i], (int)res.get(i));
		}
	}
}