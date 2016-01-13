package LT250T300;

/**
 * 260. Single Number III
 * 
 * Given an array of numbers nums, in which exactly two elements appear only
 * once and all the other elements appear exactly twice. Find the two elements
 * that appear only once.
 * 
 * E.g. Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
 * 
 * Notes: The order of the result is not important. So in the above example,
 * [5,3] is also correct.
 * 
 * Related: 136, 137
 * 
 * @author Zehao
 *
 */
public class LT260 {
	/**
	 * Find the proper criteria to separate the nums(a,b) into two arrays:
	 * nums1(a), nums2(b)
	 * Then, use XOR method in LT136 to calculate a and b.
	 * 
	 * Criteria:
	 * 1. Calculate r = a^b 
	 *    0011^0101 = 0110
	 * 2. Find the lowest bit that a and b are different (r&-r)
	 *    0110&1010 = 0010
	 * 3. Use mask r&-r to separate the original arrays
	 * 
	 */
	public int[] solve(int[] nums) {
		int r = 0;
		// find r = a^b
		for ( int num : nums ) {
			r ^= num;
		}
		int mask = r&-r; // find the lowest bit that a and b are different
		
		int a = 0, b = 0;
		for ( int num : nums ) {
			if ( (num&mask) == 0 ) a ^= num;
			else b ^= num;
		}
		return new int[] {a,b};
	}
}
