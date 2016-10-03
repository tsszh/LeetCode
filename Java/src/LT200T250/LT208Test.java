package LT200T250;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LT208Test {
	Trie trie;
	@Before
	public void initialize() {
		trie = new Trie();
		trie.insert("abc");
		trie.insert("aab");
		trie.insert("abb");
	}
	@Test
	public void initailizeTest() {
		Trie newTrie = new Trie();
		assertFalse(newTrie.search("a"));
	}
	@Test
	public void searchTest() {
		assertTrue(trie.search("abc"));
		assertFalse(trie.search("aaa"));
		assertFalse(trie.search("ab"));
	}
	@Test
	public void prefixTest() {
		assertTrue(trie.startsWith("abc"));
		assertFalse(trie.startsWith("aaa"));
		assertTrue(trie.startsWith("ab"));
		assertFalse(trie.startsWith("ac"));
	}

}
