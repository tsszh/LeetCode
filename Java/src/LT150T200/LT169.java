package LT150T200;

/**
 * 169. Majority Element
 * 
 * Given an array of size n, find the majority element. The majority element is the element that appears **more than** floor(n/2) times.
 * 
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * 
 * Similar Problem: 229. Majority Element II
 * 
 * @author Zehao
 *
 */
public class LT169 {
	/**
	 * Boyer-Moor Majority Vote
	 * 
	 * @param nums
	 * @return
	 */
	public int majorityElement(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		int count = 0, res = 0;
		for (int n : nums) {
			if (count == 0) {
				count = 1;
				res = n;
			} else if (n == res) {
				count++;
			} else {
				count--;
			}
		}
		return res;
    }
}
