package LT200T250;

/**
 * 233. Number of Digit One
 * 
 * Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.
 * 
 * For example:
 * Given n = 13,
 * Return 6, because digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.
 * 
 * @author Zehao
 *
 */
public class LT233 {
	/**
	 * abcxde
	 * 
	 * There are X 1's at digit x
	 * Integer Part: abc*100
	 * abc-1 1 99
	 *     0   0
	 * Partial Part:
	 *  abc  1 0-99 for x > 1  (100)
	 *         0-de for x == 1 (de + 1)
	 *         0    for x == 0 (0)
	 * 
	 * @param n
	 * @return
	 */
	public int countDigitOne(int n) {
		long mask = 1;
		long res = 0;
		while (mask <= n) {
			long digit = n/mask%10;
			// Integer Part
			res += n/mask/10 * mask;
			// Partial Part
			if (digit == 0) {
				res += 0;
			} else if (digit == 1) {
				res += n%mask + 1;
			} else {
				res += mask;
			}
			mask *= 10;
		}
		return (int)res;
    }
}
