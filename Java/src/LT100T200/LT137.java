package LT100T200;

/**
 * 137. Single Number II
 * 
 * Given an array of integers, every element appears three times except for one. Find that single one.
 * 
 * Related: 136, 260
 * 
 * @author Zehao
 *
 */
public class LT137 {
	/**
	 * 1001 0011 1001 1001 ---- 3014 Count the number of "1" at each bit
	 * position ---- % 3 0011 Bingo!!
	 * 
	 * Time O(n) Space O(1)
	 */
	public int bitCountMethod(int[] nums) {
		int[] res = new int[32];
		for ( int num : nums ) {
			for ( int i = 31; i >= 0; i-- ) {
				res[i] += num & 1;
				num >>= 1;
			}
		}
		int sol = 0;
		for ( int i = 0; i < 32; i++ ) {
			sol = (sol<<1)|(res[i]%3==0?0:1); // res[i]%3 might be 0, 1 or 2
		}
		return sol;
	}
}
