package LT200T250;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class LT212Test {
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][]{
			{new char[][]{
              {'o','a','a','n'},
              {'e','t','a','e'},
              {'i','h','k','r'},
              {'i','f','l','v'}
            }, new String[]{"oath","pea","eat","rain"}, new String[]{"eat","oath"}},
			{new char[0][0], new String[]{"oath","pea","eat","rain"}, new String[]{}},
			{new char[][]{
				{'a'},
				{'b'}
			}, new String[]{"a","b","ab","ba"}, new String[]{"a", "b", "ab", "ba"}},
			{new char[][]{
				{'a'},
				{'a'}
			}, new String[]{"a","b","ab","ba"}, new String[]{"a"}}
		});
	}
	@Parameter
	public char[][] board;
	@Parameter(value=1)
	public String[] words;
	@Parameter(value=2)
	public String[] expResRaw;
	
	private LT212 dummy = new LT212();
	
	@Test
	public void test() {
		List<String> res = dummy.findWords(board, words);
		Collections.sort(res);
		List<String> expRes = Arrays.asList(expResRaw);
		Collections.sort(expRes);
		assertEquals(expRes, res);
	}

}