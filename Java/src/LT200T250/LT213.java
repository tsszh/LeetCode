package LT200T250;

/**
 * 213. House Robber II
 * 
 * Note: This is an extension of 198. House Robber.
 * 
 * After robbing those houses on that street, the thief has found himself a new
 * place for his thievery so that he will not get too much attention. This time,
 * all houses at this place are arranged in a circle. That means the first house
 * is the neighbor of the last one. Meanwhile, the security system for these
 * houses remain the same as for those in the previous street.
 * 
 * Each house has a certain amount of money stashed, the only constraint
 * stopping you from robbing each of them is that adjacent houses have security
 * system connected and it will automatically contact the police if two adjacent
 * houses were broken into on the same night.
 * 
 * Given a list of non-negative integers representing the amount of money of
 * each house, determine the maximum amount of money you can rob tonight without
 * alerting the police.
 * 
 * Similar Problems: 198. House Robber
 * 					 256. Paint House
 * 					 276. Paint Fence
 * 					 337. House Robber III
 * 
 * @author Zehao
 *
 */
public class LT213 {
	public int rob(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		if (nums.length == 1)
			return nums[0];
		int aR = nums[0], aS = 0; // Rob First, Skip Last
		int bR = 0, bS = 0; // Skip First, Rob Last
		for (int i = 1; i < nums.length - 1; i++) {
			int aTmp = Math.max(aR, aS);
			aR = aS + nums[i];
			aS = aTmp;
			int bTmp = Math.max(bR, bS);
			bR = bS + nums[i];
			bS = bTmp;
		}
		// Rob First, Skip Last
		int max1 = Math.max(aR, aS);
		// Skip First, Rob Last
		int max2 = Math.max(bS + nums[nums.length - 1], bR);
		return Math.max(max1, max2);
	}
}
