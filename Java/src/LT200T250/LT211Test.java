package LT200T250;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LT211Test {
	WordDictionary trie;
	@Before
	public void initialize() {
		trie = new WordDictionary();
		trie.addWord("abc");
		trie.addWord("aab");
		trie.addWord("abb");
	}
	@Test
	public void initailizeTest() {
		WordDictionary newTrie = new WordDictionary();
		assertFalse(newTrie.search("a"));
	}
	@Test
	public void searchTest() {
		assertTrue(trie.search("abc"));
		assertFalse(trie.search("aaa"));
		assertFalse(trie.search("ab"));
	}
	@Test
	public void regexTest() {
		assertTrue(trie.search("ab."));
		assertFalse(trie.search(".."));
		assertTrue(trie.search("..."));
		assertFalse(trie.search("a.d"));
		assertFalse(trie.search("a."));
	}
}
