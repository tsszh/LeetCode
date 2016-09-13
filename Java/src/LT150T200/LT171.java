package LT150T200;

/**
 * 171. Excel Sheet Column Number
 * 
 * Related to question 168. Excel Sheet Column Title
 * 
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * 
 * For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
 * 
 * @author Zehao
 *
 */
public class LT171 {
	public int titleToNumber(String s) {
		int res = 0;
		for (int i = s.length()-1, base = 1; i >=0; i--, base *= 26) {
			res += base * (s.charAt(i) - 'A' + 1);
		}
		return res;
    }
}
