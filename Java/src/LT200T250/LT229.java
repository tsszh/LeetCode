package LT200T250;

import java.util.ArrayList;
import java.util.List;

/**
 * 229. Majority Element II
 * 
 * Given an integer array of size n, find all elements that appear more than floor(n/3) times. The algorithm should run in linear time and in O(1) space.
 * 
 * Similar Problems: 169. Majority Element II 
 * 
 * @author Zehao
 *
 */
public class LT229 {
	public List<Integer> majorityElement(int[] nums) {
		List<Integer> finalRes = new ArrayList<>();
		if (nums == null || nums.length == 0) return finalRes;
		// Initialization
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[0]) {
				int tmp = nums[i];
				nums[i] = nums[1];
				nums[1] = tmp;
				break;
			}
		}
		if (nums.length == 1 || nums[0] == nums[1]) {
			finalRes.add(nums[0]);
			return finalRes;
		}
		int[] count = new int[]{1, 2}, res = new int[]{nums[0], nums[1]};
		
		// Main Loop
		for (int i = 2; i < nums.length; i++) {
			int n = nums[i];
			if (n == res[0]) {
				count[0] += 2;
				count[1] --;
			} else if (n == res[1]) {
				count[0] --;
				count[1] +=2;
			} else if (count[0] <= 0) {
				count[0] += 2;
				count[1]--;
				res[0] = n;
			} else if (count[1] <= 0) {
				count[0]--;
				count[1]+=2;
				res[1] = n;
			} else {
				count[0]--;
				count[1]--;
			}
		}
		// Post Checking
		count = new int[]{0, 0};
		for (int n : nums) {
			if (n == res[0]) count[0]++;
			if (n == res[1]) count[1]++;
		}
		for (int i = 0; i < count.length; i++) {
			if (count[i] > nums.length / 3) finalRes.add(res[i]);
		}
		return finalRes;
    }
}
