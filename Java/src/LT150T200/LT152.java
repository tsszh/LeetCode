package LT150T200;

/**
 * 152. Maximum Product Subarray
 * 
 * Find the contiguous subarray within an array (containing at least one number)
 * which has the largest product.
 * 
 * For example, given the array [2,3,-2,4], 
 * the contiguous subarray [2,3] has the largest product = 6.
 * 
 * Similar Problems:	53. Maximum Subarray
 * 						198. House Robber
 * 						238. Product of Array Except Self 
 * 
 * @author Zehao
 *
 */
public class LT152 {
	public int maxProduct(int[] nums) {
		if (nums.length == 1)
			return nums[0];
		int[] pos = new int[nums.length + 1];
		int[] neg = new int[nums.length + 1];
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			if (num >= 0) {
				pos[i + 1] = Math.max(pos[i] * num, num);
				neg[i + 1] = Math.min(neg[i] * num, 0);
			} else {
				pos[i + 1] = Math.max(neg[i] * num, 0);
				neg[i + 1] = Math.min(pos[i] * num, num);
			}
		}

		int max = Integer.MIN_VALUE;
		for (int i = 0; i <= nums.length; i++) {
			max = Math.max(pos[i], max);
			max = Math.max(neg[i], max);
		}
		return max;
	}

	public int maxProduct2(int[] nums) {
		if (nums.length == 0)
			return 0;
		if (nums.length == 1)
			return nums[0];
		int max = 0, min = 0, totalMax = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			if (num >= 0) {
				max = Math.max(max * num, num);
				min = Math.min(min * num, 0);
			} else {
				int tempMax = max;
				max = Math.max(min * num, 0);
				min = Math.min(tempMax * num, num);
			}
			totalMax = Math.max(totalMax, max);
		}
		return totalMax;
	}
}
