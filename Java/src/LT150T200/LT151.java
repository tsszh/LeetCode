package LT150T200;

/**
 * 151. Reverse Words in a String
 * 
 * Given an input string, reverse the string word by word.
 * 
 * For example, Given s = "the sky is blue", return "blue is sky the".
 * 
 * Update (2015-02-12): For C programmers: Try to solve it in-place in O(1)
 * space.
 * 
 * Clarification: 
 * 		What constitutes a word? 
 * 			A sequence of non-space characters constitutes a word. 
 * 		Could the input string contain leading or trailing spaces? 
 * 			Yes. However, your reversed string should not contain leading or trailing spaces. 
 * 		How about multiple spaces between two words? 
 * 			Reduce them to a single space in the reversed string.
 * 
 * Similar Problems: 186. Reverse Words in a String II
 * 
 * @author Zehao
 *
 */
public class LT151 {
	public String reverseWords(String s) {
		String[] strs = s.trim().split("\\s+");
		reverse(strs);
		StringBuilder res = new StringBuilder();
		for (String str : strs) {
			res.append(str);
			res.append(' ');
		}
		return res.toString().trim();
	}

	private void reverse(String[] strs) {
		for (int left = 0, right = strs.length - 1; left < right; left++, right--) {
			String temp = strs[left];
			strs[left] = strs[right];
			strs[right] = temp;
		}
	}
}
