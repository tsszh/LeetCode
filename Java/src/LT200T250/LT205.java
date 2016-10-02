package LT200T250;

import java.util.*;

/**
 * 205. Isomorphic Strings
 * 
 * Given two strings s and t, determine if they are isomorphic.
 * 
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * 
 * All occurrences of a character must be replaced with another character while
 * preserving the order of characters. No two characters may map to the same
 * character but a character may map to itself.
 * 
 * For example, Given "egg", "add", return true.
 * 
 * Given "foo", "bar", return false.
 * 
 * Given "paper", "title", return true.
 * 
 * Tag: Hash Table
 * 
 * Similar Problems: 290. Word Pattern
 * 
 * @author Zehao
 *
 */
public class LT205 {
	public boolean isIsomorphic(String s, String t) {
		if (s.length() != t.length())
			return false;
		return convert(s).equals(convert(t));
	}

	private String convert(String s) {
		Map<Character, Integer> map = new HashMap<>(s.length());
		for (int i = 0, label = 0; i < s.length(); i++) {
			if (!map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), label++);
			}
		}
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			res.append(map.get(s.charAt(i)));
		}
		return res.toString();
	}
}
