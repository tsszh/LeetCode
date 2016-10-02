package LT200T250;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class LT207Test {
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][]{
			{2, new int[][]{
				{1,0}
			}, true},
			{2, new int[][]{
				{1,0}, {0,1}
			}, false},
			{4, new int[][]{
				{0,1}, {0,2}, {1,3}, {2,3}
			}, true},
			{4, new int[][]{
				{0,1}, {0,2}, {1,3}, {3,2}
			}, true},
			{4, new int[][]{
				{0,1}, {0,2}, {1,3}, {3,2}, {2,1}
			}, false},
			{4, new int[][]{
				{0,1}, {2,3}
			}, true},
			{2, new int[][]{
			}, true},
		});
	}
	@Parameter
	public int numCourses;
	@Parameter(value=1)
	public int[][] prerequisites;
	@Parameter(value=2)
	public boolean expRes;
	
	private LT207 dummy = new LT207();
	
	@Test
	public void test() {
		assertEquals(expRes, dummy.canFinish(numCourses, prerequisites));
	}

}
