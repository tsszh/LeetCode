package LT050T100;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class LT079Test {
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][]{
			{new String[]{
				"ABCE",
				"SFCS",
				"ADEE"
			}, "ABCCED", true},
			{new String[]{
				"ABCE",
				"SFCS",
				"ADEE"
			}, "SEE", true},
			{new String[]{
				"ABCE",
				"SFCS",
				"ADEE"
			}, "ABCB", false},
			{new String[]{
				"ABCE",
				"SFCS",
				"ADEE"
			}, "", true},
			{new String[]{
				"ABCE",
				"S"
			}, "SA", true},
			{new String[]{
				""
			}, "SA", false},
			{new String[0], "SA", false},
			{new String[0], "", false}
		});
	}
	@Parameter
	public String[] input;
	@Parameter(value=1)
	public String word;
	@Parameter(value=2)
	public boolean expRes;
	
	private LT079 dummy = new LT079();
	
	@Test
	public void test() {
		char[][] board = new char[input.length][];
		for (int i = 0; i < input.length; i++) {
			board[i] = input[i].toCharArray();
		}
		assertEquals(expRes, dummy.exist(board, word));
	}
}
