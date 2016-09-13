package LT150T200;

/**
 * 167. Two Sum II - Input array is sorted
 * 
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 * 
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 * 
 * You may assume that each input would have exactly one solution.
 * 
 * Input: numbers={2, 7, 11, 15}, target=9
 * 
 * Output: index1=1, index2=2
 * 
 * @author Zehao
 *
 */
public class LT167 {
	/**
	 * Time: O(lg(n)*lg(n))
	 * 
	 * @param numbers
	 * @param target
	 * @return
	 */
	public int[] twoSum(int[] numbers, int target) {
		int low = 0, high = numbers.length - 1;
		while (low < high) {
			high = binarySearch(numbers, low, high, target - numbers[low]);
			if (numbers[low] + numbers[high] == target) {
				return new int[]{low+1, high+1};
			}
			low++;
		}
		return null;
    }
	/**
	 * Binary Search
	 * 
	 * @param nums
	 * @param low
	 * @param high
	 * @param target
	 * @return The index of the largest element that >= target
	 */
	private int binarySearch(int[] nums, int low, int high, int target) {
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] == target) {
				while (mid < high && nums[mid + 1] == target) mid++; 
				return mid;
			} else if (nums[mid] > target) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return high;
	}
}
