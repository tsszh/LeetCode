package LT150T200;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class LT174Test {
	@Parameters
	public static Collection<Object[]> initialize() {
		return Arrays.asList(new Object[][]{
			{new int [][]{
				{1,-3,3},
				{0,-2,0},
				{-3,-3,-3}
			}, 3},
			{new int[][]{
				{-2, -3, 2},
				{-5, 1, -1},
				{10, 30, -5}
			}, 6},
			{new int[][]{
				{0}
			}, 1},
			{new int[][]{
				{-2, -3, 3},
				{-5, -10, 1},
				{10, 30, -5}
			 }, 7}
		});
	}
	@Parameter
	public int[][] dungeon;
	@Parameter(value = 1)
	public int expRes;
	
	private LT174 dummy = new LT174();
	@Test
	public void test() {
		assertEquals(expRes, dummy.calculateMinimumHP(dungeon));
	}

}
