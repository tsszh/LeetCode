package LT200T250;

/**
 * 214. Shortest Palindrome
 * 
 * Given a string S, you are allowed to convert it to a palindrome by adding
 * characters in front of it. Find and return the shortest palindrome you can
 * find by performing this transformation.
 * 
 * For example:
 * 
 * Given "aacecaaa", return "aaacecaaa".
 * 
 * Given "abcd", return "dcbabcd".
 * 
 * Similar Problems: 5. Longest Palindromic Substring
 * 					 28. Implement strStr()
 * 					 336. Palindrome Pairs
 * 
 * @author Zehao
 *
 */
public class LT214 {
	/**
	 * Time: O(n) Space: O(n)
	 * 
	 * @param s
	 * @return
	 */
	public String shortestPalindrome(String s) {
		if (s == null || s.length() < 2)
			return s;
		int[] str = new int[s.length() * 2 + 1];
		for (int i = 0; i < s.length(); i++) {
			str[2 * i + 1] = s.charAt(i);
		}
		str[0] = 1;
		str[str.length - 1] = 2;

		int[] ret = new int[str.length]; // longest palindrome centered i
		ret[0] = 1;
		int max = 1;
		for (int i = 1, id = 0, mx = 1; i < str.length - 1; i++) {
			int j = 2 * id - i;
			if (i < mx && i + ret[j] < mx) {
				ret[i] = ret[j];
			} else {
				int c = i < mx ? mx - i : 1;
				while (str[i - c] == str[i + c]) {
					c++;
				}
				ret[i] = c;
				mx = i + c;
				id = i;
				// Update longest palindrome start at s[0]
				if (i == c)
					max = i;
			}
		}
		StringBuilder tail = new StringBuilder(s.substring(max));
		return tail.reverse() + s;
	}
}
