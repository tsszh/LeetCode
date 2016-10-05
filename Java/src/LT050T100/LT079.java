package LT050T100;

import java.util.BitSet;

/**
 * 79. Word Search
 * 
 * Given a 2D board and a word, find if the word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cell, where
 * "adjacent" cells are those horizontally or vertically neighboring. The same
 * letter cell may not be used more than once.
 * 
 * For example, Given board =
 * 
 * [ 
 * 	['A','B','C','E'],
 * 	['S','F','C','S'],
 * 	['A','D','E','E']
 * ]
 * 
 * word = "ABCCED", -> returns true,
 * 
 * word = "SEE", -> returns true,
 * 
 * word = "ABCB", -> returns false.
 * 
 * Similar Problems: 212. Word Search II
 * 
 * @author Zehao
 *
 */
public class LT079 {
	public boolean exist(char[][] board, String word) {
		if (board == null || board.length == 0)
			return false;
		if (word.length() == 0)
			return true;
		char[] wordArray = word.toCharArray();
		BitSet[] mark = new BitSet[board.length];
		for (int i = 0; i < board.length; i++) {
			mark[i] = new BitSet(board[i].length);
		}
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[r].length; c++) {
				if (find(r, c, 0, mark, board, wordArray))
					return true;
			}
		}
		return false;
	}

	private boolean find(int r, int c, int level, BitSet[] mark, char[][] board, char[] word) {
		if (r < 0 || r >= board.length || c < 0 || c >= board[r].length)
			return false;
		if (mark[r].get(c))
			return false;
		if (board[r][c] != word[level++])
			return false;
		if (level == word.length)
			return true;
		mark[r].flip(c);
		if (find(r + 1, c, level, mark, board, word))
			return true;
		if (find(r - 1, c, level, mark, board, word))
			return true;
		if (find(r, c + 1, level, mark, board, word))
			return true;
		if (find(r, c - 1, level, mark, board, word))
			return true;
		mark[r].flip(c);
		return false;
	}
}
