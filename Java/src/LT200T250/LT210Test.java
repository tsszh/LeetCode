package LT200T250;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class LT210Test {
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][]{
			{2, new int[][]{
				{0,1}
			}, new int[]{1,0}},
			{2, new int[][]{
				{0,1}, {1,0}
			}, new int[]{}},
			{4, new int[][]{
				{1,0}, {2,0}, {3,1}, {3,2}
			}, new int[]{0,1,2,3}},
			{4, new int[][]{
				{1,0}, {2,0}, {3,1}, {2,3}
			}, new int[]{0,1,3,2}},
			{4, new int[][]{
				{1,0}, {2,0}, {3,1}, {2,3}, {1,2}
			}, new int[]{}},
			{4, new int[][]{
				{1, 0}, {3, 2}
			}, new int[]{0,2,1,3}},
			{2, new int[][]{
			}, new int[]{0,1}},
		});
	}
	@Parameter
	public int numCourses;
	@Parameter(value=1)
	public int[][] prerequisites;
	@Parameter(value=2)
	public int[] expRes;
	
	private LT210 dummy = new LT210();
	
	@Test
	public void test() {
		assertArrayEquals(expRes, dummy.findOrder(numCourses, prerequisites));
	}

}