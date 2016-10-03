package LT200T250;

/**
 * 209. Minimum Size Subarray Sum
 * 
 * Given an array of n positive integers and a positive integer s, find the
 * minimal length of a subarray of which the sum ¡Ý s. If there isn't one, return
 * 0 instead.
 * 
 * For example, given the array [2,3,1,2,4,3] and s = 7,
 * 
 * the subarray [4,3] has the minimal length under the problem constraint.
 * 
 * Similar Problems: 76. Minimum Window Substring
 * 					 325. Maximum Size Subarray Sum Equals k 
 * 
 * @author Zehao
 *
 */
public class LT209 {
	public int minSubArrayLen(int s, int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int minLen = Integer.MAX_VALUE;
		for (int i = 0, j = 0, sum = 0; j < nums.length; j++) {
			sum += nums[j];
			while (sum >= s) {
				minLen = Math.min(j - i + 1, minLen);
				sum -= nums[i++];
			}
		}
		if (minLen == Integer.MAX_VALUE)
			return 0;
		return minLen;
	}
}
