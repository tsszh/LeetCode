package LT150T200;

/**
 * 153. Find Minimum in Rotated Sorted Array
 * 
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * Find the minimum element.
 * 
 * The array may contain duplicates.
 * 
 * Similar Problems:	33. Search in Rotated Sorted Array 
 * 						154. Find Minimum in Rotated Sorted Array II
 * 
 * @author Zehao
 *
 */
public class LT154 {
	public int findMin(int[] nums) {
		int left = 0, right = nums.length - 1;
		while (left < right) {
			if (nums[left] < nums[right] ) {
				return nums[left];
			}
			if ( nums[left] == nums[right] ) {
				left++; continue;
			}
			int mid = (left + right) / 2;
			if (nums[mid] >= nums[left]) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return nums[left];
	}
}
