package LT100T150;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class LT140Test {
	@Parameters
	public static Collection<Object[]> testData() {
		return Arrays.asList(new Object[][]{
			{	"catsanddog",
				new ArrayList<String>( Arrays.asList(new String[]{
					"cats and dog", "cat sand dog"
				}) ),
				new HashSet<>(Arrays.asList(new String[]{
					"cat", "cats", "and", "sand", "dog"
				}))
			},
			{	"catt",
				new ArrayList<String>( Arrays.asList(new String[]{
					
				}) ),
				new HashSet<>(Arrays.asList(new String[]{
					"cat", "cats", "and", "sand", "dog"
				}))
			},
			{	"",
				new ArrayList<String>( Arrays.asList(new String[]{
					
				}) ),
				new HashSet<>(Arrays.asList(new String[]{
					"cat", "cats", "and", "sand", "dog"
				}))
			},
			{
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
				new ArrayList<String>( Arrays.asList(new String[]{
				}) ),
				new HashSet<>(Arrays.asList(new String[]{
					"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"
				}))
			}
			  
		});
	}
	
	@Parameter
	public String key;
	@Parameter(value=1)
	public List<String> expRes;
	@Parameter(value=2)
	public Set<String> wordDict;
	
	@Test
	public void test() {
		List<String> res = new LT140().wordBreakDP(key, wordDict);
		assertEquals( res.size(), expRes.size() );
		assertTrue( expRes.containsAll(res) );
	}
}