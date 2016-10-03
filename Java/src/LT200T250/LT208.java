package LT200T250;

/**
 * 208. Implement Trie (Prefix Tree)
 * 
 * Implement a trie with insert, search, and startsWith methods.
 * 
 * Note:
 * 
 * You may assume that all inputs are consist of lowercase letters a-z.
 * 
 * Similar Problems: 211. Add and Search Word - Data structure design
 * 
 * @author Zehao
 *
 */
public class LT208 {

}

class Trie {
	private TrieNode root;

	public Trie() {
		root = new TrieNode();
		root.setWordEnd();
	}

	// Inserts a word into the trie.
	public void insert(String word) {
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

	// Returns if the word is in the trie.
	public boolean search(String word) {
		TrieNode curr = root;
		for (int i = 0; i < word.length(); i++) {
			int index = word.charAt(i) - 'a';
			if (curr.get(index) == null) {
				return false;
			}
			curr = curr.get(index);
		}
		return curr.isWordEnd();
	}

	// Returns if there is any word in the trie
	// that starts with the given prefix.
	public boolean startsWith(String prefix) {
		TrieNode curr = root;
		for (int i = 0; i < prefix.length(); i++) {
			int index = prefix.charAt(i) - 'a';
			if (curr.get(index) == null) {
				return false;
			}
			curr = curr.get(index);
		}
		return true;
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

// // Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");