package LT050T100;

import java.util.*;

/**
 * 76. Minimum Window Substring
 * 
 * Given a string S and a string T, find the minimum window in S which will
 * contain all the characters in T in complexity O(n).
 * 
 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC" Minimum window is "BANC".
 * 
 * Note: If there is no such window in S that covers all characters in T, return
 * the empty string "".
 * 
 * If there are multiple such windows, you are guaranteed that there will always
 * be only one unique minimum window in S.
 * 
 * Similar Problems: 30. Substring with Concatenation of All Words
 * 					 209. Minimum Size Subarray Sum
 * 					 239. Sliding Window Maximum
 * 
 * @author Zehao
 *
 */
public class LT076 {
	public String minWindow(String s, String t) {
		if (s == null || t == null || s.length() < t.length())
			return "";
		Map<Character, Integer> map = new HashMap<>();
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < t.length(); i++) {
			char ch = t.charAt(i);
			map.put(ch, map.containsKey(ch) ? map.get(ch) + 1 : 1);
			set.add(ch);
		}
		int startIndex = -1, minLen = Integer.MAX_VALUE;
		for (int i = 0, j = 0; j < s.length(); j++) {
			char ch = s.charAt(j);
			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) - 1);
				if (map.get(ch) <= 0)
					set.remove(ch);
			}
			while (set.size() == 0) {
				if (j - i + 1 < minLen) {
					minLen = j - i + 1;
					startIndex = i;
				}
				char tmp = s.charAt(i++);
				if (map.containsKey(tmp)) {
					map.put(tmp, map.get(tmp) + 1);
					if (map.get(tmp) > 0)
						set.add(tmp);
				}
			}
		}
		if (startIndex == -1)
			return "";
		return s.substring(startIndex, startIndex + minLen);
	}
}
