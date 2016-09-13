package LT150T200;

/**
 * 168. Excel Sheet Column Title
 * 
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * 
 * For example:
    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB
 * 
 * Similar Problem: 171. Excel Sheet Column Number
 * @author Zehao
 *
 */
public class LT168 {
	public String convertToTitle(int n) {
		StringBuilder res = new StringBuilder();
		while (n != 0) {
			if (n%26 == 0) {
				res.insert(0, 'Z');
				n = n/26 - 1;
			} else {
				res.insert(0, (char)('A'+n%26-1));
				n = n/26;
			}
		}
		return res.toString();
    }
}
