package LT150T200;

/**
 * 172. Factorial Trailing Zeroes
 * 
 * Given an integer n, return the number of trailing zeroes in n!.
 * 
 * Note: Your solution should be in logarithmic time complexity.
 * 
 * @author Zehao
 *
 */
public class LT172 {
	/**
	 * Count the number of 5.
	 * \sum_{i=1}^{}{\frac{n}{5^i}}
	 * 
	 * Attention: int32 overflow problems
	 * 
	 * @param n
	 * @return
	 */
	public int trailingZeroes(int n) {
		int res = 0;
		for (long i = 5; i <= n; i *= 5) {
			res += n / i;
		}
		return res;
	}
}
