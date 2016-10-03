package LT000T050;

import java.util.*;

/**
 * 30. Substring with Concatenation of All Words
 * 
 * You are given a string, s, and a list of words, words, that are all of the
 * same length. Find all starting indices of substring(s) in s that is a
 * concatenation of each word in words exactly once and without any intervening
 * characters.
 * 
 * For example, given: s: "barfoothefoobarman" words: ["foo", "bar"]
 * 
 * You should return the indices: [0,9]. (order does not matter).
 * 
 * Tags: HashMap, Two Pointer
 * 
 * Similar Problems: 76. Minimum Window Substring
 * 
 * @author Zehao
 *
 */
public class LT030 {
	/**
	 * Sliding Window Method
	 * 
	 * Time: O(wordLen * s.length())
	 * 
	 * @param s
	 * @param words
	 * @return
	 */
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> res = new ArrayList<>();
		if (words == null || words.length == 0)
			return res;
		// Initialization
		int wordLen = words[0].length();
		int windowSize = wordLen * words.length;
		Map<String, Integer> wordsMap = new HashMap<>();
		Set<String> wordsIncompleteSet = new HashSet<>();
		for (String word : words) {
			wordsMap.put(word, wordsMap.containsKey(word) ? wordsMap.get(word) + 1 : 1);
			wordsIncompleteSet.add(word);
		}
		// Main Loop
		for (int j = 0; j < wordLen; j++) { // sliding offset
			String s2 = s.substring(j);
			Map<String, Integer> map = new HashMap<>(wordsMap);
			Set<String> set = new HashSet<>(wordsIncompleteSet);
			if (s2.length() < windowSize)
				break;
			// Fill Sliding window
			for (int i = 0; i < windowSize; i += wordLen) {
				String str = s2.substring(i, i + wordLen);
				if (map.containsKey(str)) {
					map.put(str, map.get(str) - 1);
					if (map.get(str) <= 0)
						set.remove(str);
				}
			}
			// Move Sliding Window
			for (int i = 0; i <= s2.length() - windowSize; i += wordLen) {
				if (set.size() == 0)
					res.add(i + j);
				// Move Head
				String str = s2.substring(i, i + wordLen);
				if (map.containsKey(str)) {
					map.put(str, map.get(str) + 1);
					if (map.get(str) > 0)
						set.add(str);
				}
				// Move Tail
				if (i + windowSize + wordLen > s2.length())
					break;
				str = s2.substring(i + windowSize, i + windowSize + wordLen);
				if (map.containsKey(str)) {
					map.put(str, map.get(str) - 1);
					if (map.get(str) <= 0)
						set.remove(str);
				}
			}
		}
		return res;
	}
}
