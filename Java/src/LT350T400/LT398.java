package LT350T400;

import java.util.Random;

/**
 * 
 * 398. Random Pick Index
 * 
 * Given an array of integers with possible duplicates, randomly output the index of a given target number. You can assume that the given target number must exist in the array.
 *
 * The array size can be very large. Solution that uses too much extra space will not pass the judge.
 * 
 * Example:
 * int[] nums = new int[] {1,2,3,3,3};
 * Solution solution = new Solution(nums);
 * solution.pick(3);
 * solution.pick(3);
 * ...
 * solution.pick(3);
 * 
 * And then evaluate whether [2,3,4] was picked with same the possibility.
 * 
 * @author Zehao
 *
 */
public class LT398 {
	private int[] nums;
	private Random rand;

	public LT398(int[] nums) {
		this.nums = nums;
		this.rand = new Random();
	}

	/**
	 * Reservoir Sampling Method
	 * Time: O(n) Space: O(1)
	 * 
	 * @param target
	 * @return
	 */
	public int pick(int target) {
		int k = 1, n = nums.length;
		int i = 0;
		for (; i < n; i++) {
			if (nums[i] == target) break;
		}
		int[] res = new int[] { i };
		int count = 1;
		
		for (i++; i < n; i++) {
			if (nums[i] == target) {
				if (rand.nextInt(++count) < k) { // Probability k/(count+1)
					res[0] = i;
				}
			}
		}
		return res[0];
	}
}
