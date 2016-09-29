package LT150T200;

/**
 * 189. Rotate Array
 * 
 * Rotate an array of n elements to the right by k steps.
 * 
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to
 * [5,6,7,1,2,3,4].
 * 
 * Similar Problems: 61. Rotate List 
 * 					 186. Reverse Words in a String II 
 * 
 * @author Zehao
 *
 */
public class LT189 {
	public void rotate(int[] nums, int k) {
		if (nums == null || nums.length == 0)
			return;
		for (int c = 0, i = 0, n = nums.length; c < n; c++, i++) {
			int last = nums[i];
			int j = (i + k) % n;
			while (j != i) {
				int tmp = nums[j];
				nums[j] = last;
				last = tmp;
				j = (j + k) % n;
				c++;
			}
			nums[i] = last;
		}
	}
}
