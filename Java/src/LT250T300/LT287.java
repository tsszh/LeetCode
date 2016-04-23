package LT250T300;

/**
 * 287. Find the Duplicate Number (Floyd's Loop Detection Algorithm)
 * 
 * Given an array nums containing n + 1 integers where each integer is between 1
 * and n (inclusive), prove that at least one duplicate number must exist.
 * Assume that there is only one duplicate number, find the duplicate one.
 * 
 * Note: 
 *     You must not modify the array (assume the array is read only). 
 *     You must use only constant, O(1) extra space.
 *     Your runtime complexity should be less than O(n2).
 *     There is only one duplicate number in the array, but it could be repeated more than once.
 * 
 * Similar Problems: 41. First Missing Positive 
 * 					 136. Single Number
 * 					 142. Linked List Cycle II
 *                   268. Missing Number
 * 
 * @author Zehao
 *
 */
public class LT287 {
	/**
	 * Floyd's Loop Detection Algorithm
	 * Time: O(n) Space: O(1)
	 * 
	 * @param nums
	 * @return
	 */
	public int findDuplicate(int[] nums) {
		int fast = 0, slow = 0;
		while (true) {
			fast = nums[nums[fast]];
			slow = nums[slow];
			if (fast == slow)
				break;
		}
		slow = 0;
		while (true) {
			fast = nums[fast];
			slow = nums[slow];
			if (fast == slow)
				return fast;
		}
	}
}
