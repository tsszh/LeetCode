package LT200T250;

/**
 * 201. Bitwise AND of Numbers Range
 * 
 * Given a range [m, n] where 0 <= m <= n <= 2147483647,
 * return the bitwise AND of all numbers in this range, inclusive.
 * 
 * For example, given the range [5, 7], you should return 4.
 * 
 * Tag: Bit
 * 
 * 
 * @author Zehao
 *
 */
public class LT201 {
	/**
	 * From left to right, find the first bit, in which m and n are not the same.
	 * 
	 * -------0*******
	 * ...
	 * -------10000000
	 * ...
	 * -------1*******
	 * ||
	 * VV
	 * -------00000000
	 * 
	 * @param m
	 * @param n
	 * @return
	 */
	public int rangeBitwiseAnd(int m, int n) {
		for (int i = 0; i < 32; i++) {
			if (m>>i == n>>i) return (m>>i)<<i;
		}
		return m;
	}
}
