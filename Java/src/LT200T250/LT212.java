package LT200T250;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 212. Word Search II
 * 
 * Given a 2D board and a list of words from the dictionary, find all words in
 * the board.
 * 
 * Each word must be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring. The
 * same letter cell may not be used more than once in a word.
 * 
 * For example, Given words = ["oath","pea","eat","rain"] and board =
 * 
 * [ 
 * 	['o','a','a','n'],
 * 	['e','t','a','e'],
 * 	['i','h','k','r'],
 * 	['i','f','l','v']
 * ]
 * 
 * Return ["eat","oath"].
 * 
 * Note: You may assume that all inputs are consist of lowercase letters a-z.
 * 
 * Similar Problems: 79. Word Search
 * 
 * @author Zehao
 *
 */
public class LT212 {
	public List<String> findWords(char[][] board, String[] words) {
		Set<String> res = new HashSet<>();
		if (words == null || words.length == 0)
			return new ArrayList<>();
		if (board == null || board.length == 0 || board[0].length == 0)
			return new ArrayList<>();
		Trie dict = new Trie();
		int maxLen = Integer.MIN_VALUE;
		for (String word : words) {
			dict.insert(word);
			maxLen = Math.max(maxLen, word.length());
		}
		boolean[][] mark = new boolean[board.length][board[0].length];
		char[] buff = new char[maxLen];
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[r].length; c++) {
				find(r, c, dict.getRoot(), 0, buff, mark, board, res);
			}
		}
		return new ArrayList<>(res);
	}

	private void find(int r, int c, TrieNode root, int level, char[] prefix, boolean[][] mark, char[][] board,
			Set<String> res) {
		if (r < 0 || r >= board.length || c < 0 || c >= board[r].length)
			return; // Out Of Bound
		if (mark[r][c])
			return; // Already used
		char ch = board[r][c];
		TrieNode child = root.get(ch - 'a');
		if (child == null)
			return; // No Such prefix
		prefix[level++] = ch;
		mark[r][c] = true;
		if (child.isWordEnd())
			res.add(new String(prefix, 0, level));
		find(r + 1, c, child, level, prefix, mark, board, res);
		find(r - 1, c, child, level, prefix, mark, board, res);
		find(r, c + 1, child, level, prefix, mark, board, res);
		find(r, c - 1, child, level, prefix, mark, board, res);
		mark[r][c] = false;
	}

	private class Trie {
		private TrieNode root;

		public Trie() {
			root = new TrieNode();
			root.setWordEnd();
		}

		public TrieNode getRoot() {
			return root;
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
