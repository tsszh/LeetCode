package LT350T400;

/**
 * 389. Find the Difference
 * 
 * Given two strings s and t which consist of only lowercase letters.
 *
 * String t is generated by random shuffling string s and then add one more letter at a random position.
 *
 * Find the letter that was added in t.
 * 
 * Related: 136, 137
 * 
 * @author Zehao
 *
 */

public class LT389 {
	public char findTheDifference(String s, String t) {
		int[] set = new int[26];
		for (int i = 0; i < s.length(); i++) {
			set[s.charAt(i) - 'a']++;
		}
		for (int i = 0; i < t.length(); i++) {
			char c = t.charAt(i);
			if (set[c - 'a'] == 0) return c;
			set[c - 'a']--;
		}
		return 'a';
    }
}
