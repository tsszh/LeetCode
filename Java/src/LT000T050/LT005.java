package LT000T050;

/**
 * 5. Longest Palindromic Substring
 * 
 * Given a string S, find the longest palindromic substring in S. You may assume
 * that the maximum length of S is 1000, and there exists one unique longest
 * palindromic substring.
 * 
 * Similar Problems: 214. Shortest Palindrome
 * 					 266. Palindrome Permutation
 * 					 336. Palindrome Pairs
 * 
 * @author Zehao
 *
 */
public class LT005 {
	/**
	 * 
	 * Time: O(n), Space: O(n)
	 * 
	 * 1st: abb => ^|a|b|b|$
	 * 
	 * ret[i]: Half of the longest palindromic string centered at ret[i]
	 * mx: The left most untouched slot
	 * id: The center corresponding to mx
	 * 
	 * 
	 * @param s
	 * @return
	 */
	public String longestPalindrome(String s) {
		if (s == null || s.length() < 2)
			return s;
		int[] str = new int[s.length() * 2 + 3];
		for (int i = 0; i < s.length(); i++) {
			str[2 * i + 2] = s.charAt(i);
		}
		str[0] = 1;
		str[str.length - 1] = 2;

		int[] ret = new int[str.length]; // longest palindrome centered i
		ret[0] = 1;
		int maxId = 0;
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
				// Update longest palindrome
				if (c > ret[maxId]) {
					maxId = i;
				}
			}
		}
		StringBuilder res = new StringBuilder();
		if (maxId % 2 == 0)
			res.append((char) str[maxId]);
		for (int i = 1; i < ret[maxId]; i++) {
			char ch = (char) str[maxId + i];
			if (ch > 3) {
				res.insert(0, ch);
				res.append(ch);
			}
		}
		return res.toString();
	}
}
