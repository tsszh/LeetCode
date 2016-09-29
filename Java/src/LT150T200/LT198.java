package LT150T200;

/**
 * 198. House Robber
 * 
 * You are a professional robber planning to rob houses along a street. Each
 * house has a certain amount of money stashed, the only constraint stopping you
 * from robbing each of them is that adjacent houses have security system
 * connected and it will automatically contact the police if two adjacent houses
 * were broken into on the same night.
 * 
 * Given a list of non-negative integers representing the amount of money of
 * each house, determine the maximum amount of money you can rob tonight without
 * alerting the police.
 * 
 * Tags: Dynamic Programming, Finite State Machine
 * 
 * Similar Problems: 152. Maximum Product Subarray
 * 					 213. House Robber II
 * 					 256. Paint House
 * 					 276. Paint Fence
 * 					 337. House Robber III
 * 
 * 
 * @author Zehao
 *
 */
public class LT198 {
	/**
	 * FSM     
	 * -----> S --rob-> R
	 * |     | ^        |
	 * -skip-| |--skip--|
	 * 
	 * s[n] = max{s[n-1], r[n-1]}
	 * r[n] = s[n-1] + amount[n]
	 * 
	 * @param nums
	 * @return
	 */
	public int rob(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int s = 0, r = 0;
		for (int i = 0; i < nums.length; i++) {
			int tmpS = Math.max(s, r);
			r = s + nums[i];
			s = tmpS;
		}
		return Math.max(r, s);
	}
}
