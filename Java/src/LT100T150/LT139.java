package LT100T150;

import java.util.Set;

/**
 * 139. Word Break
 * 
 * Given a string s and a dictionary of words dict, determine if s can be
 * segmented into a space-separated sequence of one or more dictionary words.
 * 
 * For example, given s = "leetcode", dict = ["leet", "code"].
 * 
 * Return true because "leetcode" can be segmented as "leet code".
 * 
 * @author Zehao
 *
 */
public class LT139 {
	/**
	 * Typical DP solution
	 * 
	 *   l e e t c o d e
	 * y x x x y x x x y
	 * 
	 * Time: O(n^2) Space: O(n)
	 * 
	 * @param s The word to be found
	 * @param wordDict Word Dictionary
	 * @return
	 */
	public boolean wordBreak(String s, Set<String> wordDict) {
		int n = s.length();
		boolean[] res = new boolean[n + 1];
		res[0] = true;

		for (int t = 0; t < n; t++) {
			for (int h = 0; h <= t; h++) {
				if (!res[h])
					continue;
				String temp = s.substring(h, t + 1);
				if (wordDict.contains(temp)) {
					res[t + 1] = true;
					break;
				}
			}
		}

		return res[n];
	}
	
	/**
	 * Optimized DP
	 * 
	 * Considering the maximum length of string in dictionary
	 * 
	 * Time: O(n*m) Space: O(n) // n = s.length(); m = maxLenOfWordDict(wordDict)
	 * 
	 * @param s
	 * @param wordDict
	 * @return
	 */
	public boolean wordBreakQuick(String s, Set<String> wordDict) {
		int n = s.length(),
			maxLen=0;
		for ( String key : wordDict ) {
			if ( key.length() > maxLen ) maxLen = key.length();
		}
		boolean[] res = new boolean[n + 1];
		res[0] = true;

		for (int t = 0; t < n; t++) {
			int h = Math.max(0, t-maxLen+1);
			for (; h <= t; h++) {
				if (!res[h])
					continue;
				String temp = s.substring(h, t + 1);
				if (wordDict.contains(temp)) {
					res[t + 1] = true;
					break;
				}
			}
		}

		return res[n];
	}
}
