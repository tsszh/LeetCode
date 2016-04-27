package LT100T150;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import utilities.*;

@RunWith(Parameterized.class)
public class LT144Test {
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][]{
			{"{1,2,3,#,#,4,#,#,5}", new int[]{1,2,3,4,5}},
			{"{1,2,4,3,#,#,5}", new int[]{1,2,3,4,5}},
			{"{}", new int[]{}},
			{"{1}", new int[]{1}}
		});
	}
	@Parameter
	public String treeString;
	@Parameter(value=1)
	public int[] expRes;
	
	private LT144 dummy = new LT144();
	private TreeNode root;
	
	@Before
	public void initialize(){
		root = TreeFactory.deserialize(treeString);
	}
	@Test
	public void test() {
		List<Integer> res = dummy.preorderTraversal(root);
		assertEquals( expRes.length, res.size() );
		for ( int i = 0; i < res.size(); i++ )
			assertTrue( expRes[i] == res.get(i) );
	}
	
	@Test
	public void test2() {
		List<Integer> res = dummy.preorderTraversal2(root);
		assertEquals( expRes.length, res.size() );
		for ( int i = 0; i < res.size(); i++ )
			assertTrue( expRes[i] == res.get(i) );
	}

}
