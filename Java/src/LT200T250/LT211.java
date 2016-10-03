package LT200T250;

/**
 * 211. Add and Search Word - Data structure design
 * 
 * Design a data structure that supports the following two operations:
 * 
 * void addWord(word) 
 * bool search(word) 
 * 
 * search(word) can search a literal word
 * or a regular expression string containing only letters a-z or .. A . means it
 * can represent any one letter.
 * 
 * For example:
 * 
 * addWord("bad") 
 * addWord("dad") 
 * addWord("mad") 
 * search("pad") -> false
 * search("bad") -> true 
 * search(".ad") -> true 
 * search("b..") -> true 
 * 
 * Note: You may assume that all words are consist of lowercase letters a-z.
 * 
 * Tag: Trie, DFS
 * 
 * Similar Problems: 208. Implement Trie (Prefix Tree)
 * 
 * @author Zehao
 *
 */
public class LT211 {

}

class WordDictionary {
	private TrieNode root;

	public WordDictionary() {
		root = new TrieNode();
		root.setWordEnd();
	}

	// Adds a word into the data structure.
	public void addWord(String word) {
		TrieNode curr = root;
		for (int i = 0; i < word.length(); i++) {
			int index = word.charAt(i) - 'a';
			if (curr.get(index) == null) {
				curr.set(index);
			}
			curr = curr.get(index);
		}
		curr.setWordEnd();
	}

	// Returns if the word is in the data structure. A word could
	// contain the dot character '.' to represent any one letter.
	public boolean search(String word) {
		return searchHelper(root, word);
	}

	private boolean searchHelper(TrieNode curr, String word) {
		if (word.length() == 0)
			return curr.isWordEnd();
		if (word.charAt(0) == '.') {
			for (int j = 0; j < 26; j++) {
				if (curr.get(j) == null)
					continue;
				if (searchHelper(curr.get(j), word.substring(1)))
					return true;
			}
			return false;
		}
		int index = word.charAt(0) - 'a';
		if (curr.get(index) == null) {
			return false;
		}
		return searchHelper(curr.get(index), word.substring(1));
	}

	private class TrieNode {
		// Initialize your data structure here.
		TrieNode[] childs;
		boolean wordEnd;

		public TrieNode() {
			childs = new TrieNode[26];
		}

		public TrieNode get(int index) {
			return childs[index];
		}

		public void set(int index) {
			childs[index] = new TrieNode();
		}

		public boolean isWordEnd() {
			return wordEnd;
		}

		public void setWordEnd() {
			wordEnd = true;
		}
	}
}