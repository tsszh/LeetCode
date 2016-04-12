package LT100T150;

import java.util.HashSet;

/**
 * 136. Single Number
 * 
 * Given an array of integers, every element appears twice except for one. Find
 * that single one.
 * 
 * Related: 137, 260
 * 
 * @author Zehao
 *
 */
public class LT136 {
	/**
	 * A^B^B = A
	 * 
	 * Time O(n) Space O(1)
	 */
	public int xorMethod(int[] nums) {
		int res = 0;
		for (int num : nums) {
			res ^= num;
		}
		return res;
	}

	/**
	 * Use HashTable to keep track of the appearance of elements.
	 * 
	 * Time O(n) Space O(n)
	 */
	public int hashTableMethod(int[] nums) {
		HashSet<Integer> hash = new HashSet<>(nums.length / 2);
		for (int num : nums) {
			if (hash.contains(num))
				hash.remove(num);
			else
				hash.add(num);
		}
		return (int) hash.toArray()[0];
	}
}
