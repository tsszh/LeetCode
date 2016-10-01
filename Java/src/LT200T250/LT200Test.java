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
public class LT200Test {
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][]{
			{new String[]{
					"11110",
					"11010",
					"11000",
					"00001"
			}, 2},
			{new String[]{
					"11000",
					"11000",
					"00100",
					"00011"
			}, 3},
			{new String[]{}, 0},
			{new String[]{""}, 0},
			{new String[]{"1","0","1"}, 2},
			{new String[]{"10101"}, 3}
		});
	}
	@Parameter
	public String[] pregrid;
	@Parameter(value=1)
	public int expRes;
	
	private LT200 dummy = new LT200();
	
	@Test
	public void test() {
		char[][] grid;
		if (pregrid.length != 0) {
			grid = new char[pregrid.length][pregrid[0].length()];
		} else {
			grid = new char[0][0];
		}
		
		for (int r = 0; r < pregrid.length; r++) {
			String temp = pregrid[r];
			for (int c = 0; c < temp.length(); c++ ) {
				grid[r][c] = temp.charAt(c);
			}
		}
		int res = dummy.numIslands(grid);
		assertEquals( expRes, res );
	}

}