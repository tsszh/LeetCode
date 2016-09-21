package LT050T100;

/**
 * 53. Maximum Subarray
 * 
 * Find the contiguous subarray within an array (containing at least one number)
 * which has the largest sum.
 * 
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4], the contiguous subarray
 * [4,-1,2,1] has the largest sum = 6.
 * 
 * @author Zehao
 *
 */
public class LT53 {
	/**
	 * Dynamic Programming Time: O(n) Space: O(1)
	 * 
	 * maxSum[i] = max{ nums[i], maxSum[i-1] + nums[i] }
	 * 
	 * @param nums
	 * @return
	 */
	public int maxSubArray(int[] nums) {
		if (nums == null)
			return 0;
		int res = Integer.MIN_VALUE;
		int preSum = -1;
		for (int i = 0; i < nums.length; i++) {
			if (preSum >= 0) {
				preSum += nums[i];
			} else {
				preSum = nums[i];
			}
			res = Math.max(res, preSum);
		}
		return res;
	}
	
	/**
	 * Divide & Conquer
	 * 
	 * Time: O(nlgn) Space: O(1)
	 * 
	 * T(n) = 2T(n/2) + O(n)
	 * 
	 * @param nums
	 * @return
	 */
	public int maxSubArray2(int[] nums) {
		if (nums == null || nums.length == 0) return Integer.MIN_VALUE;
		return maxSubArrayHelper(nums, 0, nums.length - 1);
	}
	private int maxSubArrayHelper(int[] nums, int start, int end) {
		if (end < start) return Integer.MIN_VALUE;
		int mid = start + (end - start)/2;
		int left = maxSubArrayHelper(nums, start, mid -1);
		int right = maxSubArrayHelper(nums, mid + 1, end);
		int max = crossArrayMax(nums, start, end, mid);
		if (left > max) max = left;
		if (right > max) max = right;
		return max;
	}
	private int crossArrayMax(int[] nums, int start, int end, int mid) {
		int res = nums[mid];
		int sum = 0, max = 0;
		for (int i = mid -1; i >= start; i--) {
			sum += nums[i];
			if (sum > max) max = sum;
		}
		if (max > 0) res += max;
		sum = 0;
		max = 0;
		for (int i = mid + 1; i <= end; i++) {
			sum += nums[i];
			if (sum > max) max = sum;
		}
		if (max > 0) res += max;
		return res;
	}
}
